package kr.green.green.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.pagination.Criteria;
import kr.green.green.pagination.PageMaker;
import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	

	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public ModelAndView listGet(ModelAndView mv, Criteria cri){
		System.out.println(cri);
		cri.setPerPageNum(2);
		//System.out.println(cri);		
		List<BoardVO> list = boardService.getBoardList(cri);
		//System.out.println(list);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);		
		System.out.println(pm);
		mv.addObject("pm",pm);
		mv.addObject("list", list)
			.setViewName("/board/list");
	    return mv;
	}
	
	@RequestMapping(value= "/detail", method=RequestMethod.GET)
	public ModelAndView detailGet(ModelAndView mv, Integer bd_num, HttpServletRequest request){
		//System.out.println(bd_num);
		BoardVO board = boardService.getBoardDetail(bd_num);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//게시글 번호와 일치하는 첨부파일을 가져오라고 시킴
		List<FileVO> fileList = boardService.getFileList(bd_num);
		
		if(user!=null) {
			LikesVO likes = new LikesVO();
			likes.setLi_bd_num(bd_num);
			likes.setLi_me_id(user.getMe_id());
			LikesVO dblikes = (LikesVO) boardService.getLikes(likes);
			mv.addObject("dblikes", dblikes);
		}
		mv.addObject("fileList", fileList);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
	    return mv;
	}
	
	@RequestMapping(value= "/register", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv, Integer bd_ori_num, String type, HttpServletRequest request){
//		System.out.println(type);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");

		if(type.equals("공지")   && user.getMe_authority().equals("회원")) {
			mv.addObject("type", type);
			mv.setViewName("redirect:/board/list");
		}else {
			mv.addObject("bd_type", type);
			mv.addObject("bd_ori_num", bd_ori_num);
			mv.setViewName("/board/register");
		}	
	    return mv;
	}
	
	@RequestMapping(value= "/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest request, List<MultipartFile> files2, String bd_type) throws Exception {		
//		System.out.println(bd_type);		
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
//		System.out.println(user);
		board.setBd_me_id(user.getMe_id());		
		if(bd_type.equals("공지")   && user.getMe_authority().equals("회원")) {
			
		}else {
			boardService.registerBoard(board, files2);			
			//System.out.println(user);			
		}
		mv.addObject("type", bd_type);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	

	
	@RequestMapping(value= "/modify", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request, String type){
		//System.out.println(bd_num);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoardDetail(bd_num);
		//게시글 번호와 일치하는 첨부파일을 가져오라고 시킴
		List<FileVO> fileList = boardService.getFileList(bd_num);		
		
		if(user != null && board != null && user.getMe_id().equals(board.getBd_me_id())) {
			mv.addObject("fileList", fileList);
			mv.addObject("board", board);
			mv.addObject("bd_type", type);
			mv.setViewName("/board/modify");
		}else {
			mv.addObject("bd_num",bd_num);
			mv.setViewName("redirect:/board/detail");
		}
	    return mv;
	}
	
	@RequestMapping(value= "/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request,
			List<MultipartFile> files2, Integer [] fileNums, String bd_type) {
		System.out.println(bd_type);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		boardService.modifyBoard(board, user, files2, fileNums);
		mv.addObject("type", bd_type);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
	@RequestMapping(value= "/delete", method=RequestMethod.GET)
	public ModelAndView deleteGet(ModelAndView mv, BoardVO board, HttpServletRequest request,
			List<MultipartFile> files2, Integer [] fileNums){		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		BoardVO board2 = boardService.getBoardDetail(board.getBd_num());
		System.out.println(user);
		System.out.println(board2);
		if(user != null && board != null && user.getMe_id().equals(board2.getBd_me_id())) {
			System.out.println("삭제 시작");
			boardService.deleteBoard(board.getBd_num(),user, files2, fileNums);
			mv.addObject("type", board2.getBd_type());
			mv.setViewName("redirect:/board/list");
		}else {
			System.out.println("삭제 안시작");			
			mv.addObject("bd_num",board.getBd_num());
			mv.setViewName("redirect:/board/detail");
		}
	    return mv;
	    
	}
	

	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		String uploadPath = "D:\\JAVA_JSJ\\upload";
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	@ResponseBody
	@RequestMapping(value= "/likes", method=RequestMethod.POST)
	public String boardLikes(HttpServletRequest request, @RequestBody LikesVO likes) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null)
			return "usernull";
		LikesVO dblikes = (LikesVO) boardService.getLikes(likes);
		if(dblikes == null) {
			boardService.insertLikes(likes);
		}else {			
			likes.setLi_num(dblikes.getLi_num());
			if(dblikes.getLi_state()==likes.getLi_state())
				likes.setLi_state(0);
			boardService.updateLikes(likes);
		}
	    return (""+likes.getLi_state());
	}
}

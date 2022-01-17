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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	

	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public ModelAndView listGet(ModelAndView mv){
		List<BoardVO> list = boardService.getBoardList("일반");
		//System.out.println(list);
		mv.addObject("list", list)
			.setViewName("/board/list");
	    return mv;
	}
	
	@RequestMapping(value= "/detail", method=RequestMethod.GET)
	public ModelAndView detailGet(ModelAndView mv, Integer bd_num){
//		System.out.println(bd_num);
		BoardVO board = boardService.getBoardDetail(bd_num);
		//게시글 번호와 일치하는 첨부파일을 가져오라고 시킴
		List<FileVO> fileList = boardService.getFileList(bd_num);
		mv.addObject("fileList", fileList);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
	    return mv;
	}
	
	@RequestMapping(value= "/register", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv){
		mv.setViewName("/board/register");
	    return mv;
	}
	
	@RequestMapping(value= "/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest request, List<MultipartFile> files) throws Exception {		
		//System.out.println(board);		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		boardService.registerBoard(board, files);
		
		//System.out.println(user);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	

	
	@RequestMapping(value= "/modify", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request){
		//System.out.println(bd_num);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoardDetail(bd_num);
		if(user != null || board != null || user.getMe_id().equals(board.getBd_me_id())) {
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}else {
			mv.addObject("bd_num",bd_num);
			mv.setViewName("redirect:/board/detail");
		}
	    return mv;
	}
	
	@RequestMapping(value= "/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request){
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		boardService.modifyBoard(board,user);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
	@RequestMapping(value= "/delete", method=RequestMethod.GET)
	public ModelAndView deleteGet(ModelAndView mv, BoardVO board, HttpServletRequest request){		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");	
		System.out.println(user);
		System.out.println(board);
		if(user != null && board != null && user.getMe_id().equals(board.getBd_me_id())) {
			System.out.println("삭제 시작");
			boardService.deleteBoard(board.getBd_num(),user);
			mv.setViewName("redirect:/board/list");
		}else {
			System.out.println("삭제 안시작");			
			mv.addObject("bd_num",board.getBd_num());
			mv.setViewName("redirect:/board/detail");
		}
	    return mv;
	    
	}
	

	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
		String uploadPath = "D:\\JAVA_JSJ\\upload";
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
}

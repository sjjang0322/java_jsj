package kr.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
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
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest request){
		//System.out.println(board);		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		boardService.registerBoard(board);
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
	
	

}

package kr.green.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.green.service.CommentService;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@RestController
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public boolean commentRegister(@RequestBody CommentVO comment, HttpServletRequest request){
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		return commentService.registerComment(comment, user);
	}
}

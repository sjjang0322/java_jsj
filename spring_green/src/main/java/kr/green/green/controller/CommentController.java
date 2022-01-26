package kr.green.green.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.green.green.service.CommentService;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@RestController
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public boolean commentRegister(@RequestBody CommentVO comment, HttpServletRequest request){
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		return commentService.registerComment(comment, user);
	}
	
	@RequestMapping(value ="/list", method=RequestMethod.GET)
	public Map<String, Object> commentList(Integer page, Integer bd_num){		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentVO> list = commentService.selectComment(bd_num);
		map.put("list", list);
		return map;
	}
}

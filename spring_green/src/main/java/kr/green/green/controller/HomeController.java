package kr.green.green.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
    @Autowired
    MemberService memberService;

	@RequestMapping(value= "/")
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}

	


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");	
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user) {
		
		MemberVO loginUser = memberService.login(user);
		mv.addObject("user",loginUser);
		if(loginUser == null)
			mv.setViewName("redirect:/login");	
		else
			mv.setViewName("redirect:/");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv, MemberVO user) {
		
		mv.setViewName("/member/signup");
		mv.addObject("user",user);
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {		
		
		if(memberService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("user",user);
			mv.setViewName("redirect:/signup");
		}				
		return mv;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("redirect:/");	
		request.getSession().removeAttribute("user");
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView boardGet(ModelAndView mv) {
		mv.setViewName("/board/list");		
		return mv;
	}
}

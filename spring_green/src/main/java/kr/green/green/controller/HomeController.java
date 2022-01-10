package kr.green.green.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		mv.setViewName("/main/home");		
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/member/signup");		
		return mv;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv) {
		mv.setViewName("redirect:/");		
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView boardGet(ModelAndView mv) {
		mv.setViewName("/board/list");		
		return mv;
	}
}

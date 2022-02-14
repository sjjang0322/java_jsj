package kr.green.green.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= "/")
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    return mv;
	}
	@RequestMapping(value= "/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv){
	    mv.setViewName("/member/signup");
	    return mv;
	}
	@RequestMapping(value= "/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user){
		boolean isSignup = memberService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
	    return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
	    mv.setViewName("/member/login");
	    return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user){
		
		MemberVO loginUser = memberService.login(user);
		mv.addObject("user",loginUser);
		if(loginUser == null)
			mv.setViewName("redirect:/login");
		else
			mv.setViewName("redirect:/");
	    return mv;
	}
	@RequestMapping(value= "/logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest r){
		r.getSession().removeAttribute("user");
	    mv.setViewName("redirect:/");
	    return mv;
	}
	
	@ResponseBody
	@RequestMapping(value ="/idduplicated")
	public String idduplicated(String id){
		System.out.println(id);
	    if(memberService.isDuplicated(id))
	    	return "true";
	    return "false";
	}
	
	@RequestMapping(value= "/mypage", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv){
	    mv.setViewName("/member/mypage");
	    return mv;
	}
	
	@RequestMapping(value= "/mypage", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, MemberVO usermod, HttpServletRequest request){
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null||user.getMe_id().equals(usermod.getMe_id())) {
			boolean isModify = memberService.modify(usermod);
			if(isModify) {				
				MemberVO dbUser = memberService.loadUser(user);	
				if(dbUser!=null)
					request.getSession().setAttribute("user", dbUser);
				mv.setViewName("redirect:/");
			}else {
				mv.setViewName("redirect:/mypage");
			}
		}else {
			mv.setViewName("redirect:/mypage");
		}
		return mv;
	}
	
	@RequestMapping(value= "/member/find", method=RequestMethod.GET)
	public ModelAndView findGet(ModelAndView mv){
	    mv.setViewName("/member/find");
	    return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/member/find/id")
	public String memberFindId(@RequestBody MemberVO user){
		return memberService.findId(user);
	}
	
	@ResponseBody
	@RequestMapping(value ="/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO user){
		
		
		return memberService.findPw(user);
	}
	
	
	
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "/mail/mailForm")
	public String mailForm() {

	    return "mail";
	}  

	// mailSending 코드
	@RequestMapping(value = "/mail/mailSending")
	public String mailSending(HttpServletRequest request) {

	    String setfrom = "stajun@naver.com";         
	    String tomail  = request.getParameter("tomail");     // 받는 사람 이메일
	    String title   = request.getParameter("title");      // 제목
	    String content = request.getParameter("content");    // 내용

	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	    }

	    return "redirect:/mail/mailForm";
	}

}

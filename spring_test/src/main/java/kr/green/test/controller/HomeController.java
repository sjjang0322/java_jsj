package kr.green.test.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

//@controller가 있어야 URL을 분석하여 처리
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	// URL을 확인하는 곳, 필수
	// value는 localhost:8080/패키지명을 제외한 부분
	// method는 전달 방식, GET,POST, 생략하면 둘다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		mv.setViewName("/main/home");
		//화면으로 데이터를 보낼때 addObject를 사용
		//addObject("화면에서 사용할 이름",데이터);
		mv.addObject("serverTime","데이터");
		
		return mv;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");		
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		
		
		MemberVO user = memberService.login(member);
		if(user == null) {
			mv.setViewName("redirect:/login");
		}else {
			//user는 DB에서 아이디, 비번과 일치하는 회원 정보를 가져온 것이기 때문에
			//로그인 확면에서 선택한 자동 로그인 체크 유무를 알 수 없다
			//화면에서 전달한 member에 있는 자동 로그인 체크 유무를 user에 설정
			user.setMe_auto_login(member.getMe_auto_login());			
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}			
		return mv;
	}

	@RequestMapping(value= {"/main/home","/home.do"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
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
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user != null) {
			//세션에 있는 유저 정보를 삭제
			request.getSession().removeAttribute("user");
			//request에 있는 쿠키들 중에서 loginCookie 정보를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//loginCookie 정보가 있으면 => 자동로그인 했다가 로그아웃 하는 경우
			if(cookie != null) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				//자동 로그인 해제를 위해 세션 아이디에 none을 저장하고, 만료시간을 현재시간으로 설정
				user.setMe_session_id("none");
				user.setMe_session_limit(new Date());
				memberService.updateAutoLogin(user);
			}
		}
		
		mv.setViewName("redirect:/");		
		return mv;
	}
	
	@RequestMapping(value ="/idcheck")
	@ResponseBody
	public String ajaxTest1(String id) {
		
		if(!memberService.idDuplicated(id))
			return "ok";
		return "no";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO member) {
		
		return memberService.findPw(member);
	}
	

}

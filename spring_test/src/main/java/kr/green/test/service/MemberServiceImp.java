package kr.green.test.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		//로그인에 성공하면 회원정보를 실패하면 null을 반환
		if(user == null)
			return null;
		//matches(원래 비번, 암호화된 비번) : 같으면(비번이 맞으면) true 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

	@Override
	public boolean signup(MemberVO user) {
		//필수 항목이 null인지 체크		
		if(user == null)
			return false;
		if(user.getMe_id() == null)
			return false;
		if(user.getMe_pw() == null)
			return false;
		if(user.getMe_name() == null)
			return false;
		if(user.getMe_phone() == null)
			return false;
		if(user.getMe_gender() == null)
			return false;
		if(user.getMe_address() == null)
			return false;
		//아이디 중복체크
		if(memberDao.getMember(user.getMe_id()) != null)
				return false;		
		//암호화된 비밀번호
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
		
		
	}

}

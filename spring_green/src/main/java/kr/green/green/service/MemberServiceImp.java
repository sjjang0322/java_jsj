package kr.green.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		//회원가입 안되는 경우 확인해서 회원가입 진행
		if(user == null)
			return false;
		//아이디 가능한지 확인
		if(user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return false;
		//비밀번호 가능한지 확인
		
		//성별 가능한지 확인
		
		//가능하다면 회원가입을 진행
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public MemberVO login(MemberVO user) {
		if(user== null || user.getMe_id()==null 
			|| user.getMe_id().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		if(dbUser == null)
			return null;
		if(!passwordEncoder.matches(user.getMe_pw(), dbUser.getMe_pw()))
			return null;
		return dbUser;
	}

	@Override
	public boolean isDuplicated(String id) {
		//중복이면 true 아니면 false
		System.out.println(id);
		MemberVO user = memberDao.selectMember(id);
		System.out.println(user);
		if(memberDao.selectMember(id) == null)
			return false;
		return true;
	}

	@Override
	public boolean modify(MemberVO user) {
		if(user==null || user.getMe_birth()==null || user.getMe_gender()==null || user.getMe_id()==null || user.getMe_name()==null
				|| user.getMe_phone()==null)
			return false;
		memberDao.updateMember(user);
		if(!user.getMe_pw().equals("")&&user.getMe_pw()!=null) {
			String encPw = passwordEncoder.encode(user.getMe_pw());
			user.setMe_pw(encPw);
			memberDao.updateMemberPassword(user);
		}
		if(!user.getMe_address().equals(" ")&&user.getMe_address()!=null) {
			memberDao.updateMemberAddress(user);
		}
		return true;
	}

	@Override
	public MemberVO loadUser(MemberVO user) {
		if(user==null||user.getMe_id()==null) {
			return null;
		}
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		return dbUser;
	}

	@Override
	public String findId(MemberVO user) {
		if(user==null||user.getMe_name()==null||user.getMe_email()==null)
			return null;		
		return memberDao.findId(user);
	}

	@Override
	public String findPw(MemberVO user) {
		if(user==null||user.getMe_id()==null||user.getMe_email()==null)
			return null;		
		if(memberDao.findPw(user)==null)
			return null;
		MemberVO dbUser = (MemberVO)memberDao.findPw(user);
		if(dbUser==null)
			return null;
		String pw = "";
		for(int i=0;i<26;i++) {
			int tmp = (int) (Math.random()*61);
			if(tmp<10) {
				pw += (char)(tmp+48);
			} else if(tmp<36){
				pw += (char)(tmp+65);
			} else if(tmp<62){
				pw += (char)(tmp+97);
			}
		}
		String encPw = passwordEncoder.encode(pw);
		user.setMe_pw(encPw);
		memberDao.updateMemberPassword(user);
		return pw;
	}
}

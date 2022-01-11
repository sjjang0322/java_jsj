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
	public MemberVO test(String id) {		
		return memberDao.test(id);
	}

	@Override
	public boolean signup(MemberVO user) {
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

	@Override
	public MemberVO login(MemberVO user) {
		if(user==null || user.getMe_id()==null || user.getMe_id().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		if(dbUser == null)
			return null;
		if(passwordEncoder.matches(user.getMe_pw(), dbUser.getMe_pw()))
			return null;
		return null;
	}
	

 
}
package kr.green.test.service;

import kr.green.test.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO user);

	boolean idDuplicated(String id);
	
}

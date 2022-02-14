package kr.green.green.service;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO login(MemberVO user);

	boolean isDuplicated(String id);

	boolean modify(MemberVO user);

	MemberVO loadUser(MemberVO user);

	String findId(MemberVO user);

	String findPw(MemberVO user);

	

}

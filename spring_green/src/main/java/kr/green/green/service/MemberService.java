package kr.green.green.service;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	MemberVO test(String id);

	boolean signup(MemberVO user);

	MemberVO login(MemberVO user);
    
}
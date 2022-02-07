package kr.green.test.service;

import java.util.List;

import kr.green.test.vo.MemberVO;

public interface AdminService {

	List<MemberVO> getMemberList();

	boolean updateAythority(MemberVO member);


}

package kr.green.green.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;

public interface MemberDAO {

	void insertMember(@Param("user")MemberVO user);

	MemberVO selectMember(@Param("me_id")String me_id);

	void updateMember(@Param("user")MemberVO user);

	void updateMemberPassword(@Param("user")MemberVO user);

	void updateMemberAddress(@Param("user")MemberVO user);
	
	String findId(@Param("user")MemberVO user);

	MemberVO findPw(@Param("user")MemberVO user);

}

package kr.green.green.dao;
 
import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;
 
public interface MemberDAO {

	MemberVO test(@Param("id")String id);

	Object getMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);

	MemberVO selectMember(@Param("me_id")String me_id);
 
}
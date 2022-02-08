package kr.green.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MainCategoryVO;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.MiddleCategoryVO;
import kr.green.test.vo.SubCategoryVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);

	void updateMember(@Param("user")MemberVO user);

	List<MemberVO> selectMemberList();

	void updateAutoLogin(@Param("user")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);

	MemberVO paramTest1(@Param("user")MemberVO user);
	
	MemberVO paramTest2(MemberVO user);

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(@Param("mi_ma_num")Integer mi_ma_num);

	List<SubCategoryVO> selectSubCategory(@Param("su_mi_num")Integer su_mi_num);
	
}

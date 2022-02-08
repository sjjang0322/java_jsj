package kr.green.test.service;

import java.util.List;

import kr.green.test.vo.MainCategoryVO;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.MiddleCategoryVO;
import kr.green.test.vo.SubCategoryVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO user);

	boolean idDuplicated(String id);

	String findPw(MemberVO member);

	void updateAutoLogin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

	void paramTest();

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(Integer mi_ma_num);

	List<SubCategoryVO> selectSubCategory(Integer su_mi_num);
	
}

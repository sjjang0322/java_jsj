package kr.green.test.service;

import java.util.List;

import kr.green.test.vo.CommentVO;
import kr.green.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectCommentList(Integer co_bd_num);

}

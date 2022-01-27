package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

public interface CommentService {

	boolean registerComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectCommentList(Integer co_bd_num);

	
}

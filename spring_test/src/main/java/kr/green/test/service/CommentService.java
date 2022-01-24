package kr.green.test.service;

import kr.green.test.vo.CommentVO;
import kr.green.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

}

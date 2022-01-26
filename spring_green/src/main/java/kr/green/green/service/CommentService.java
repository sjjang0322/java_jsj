package kr.green.green.service;

import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

public interface CommentService {

	boolean registerComment(CommentVO comment, MemberVO user);

	
}

package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.CommentDAO;
import kr.green.test.vo.CommentVO;
import kr.green.test.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService{

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null)			
			return false;
		//댓글 작성자에 로그인한 회원 아이디를 넣어줌
		comment.setCo_me_id(user.getMe_id());
		commentDao.insertComment(comment);
		return true;
	}
	
}
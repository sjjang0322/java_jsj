package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.CommentDAO;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;


@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean registerComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		if(!comment.getCo_me_id().equals(user.getMe_id()))
			return false;
		
		commentDao.insertComment(comment);
		return true;
	}

	@Override
	public List<CommentVO> selectCommentList(Integer co_bd_num) {
		if(co_bd_num == null || co_bd_num <= 0)
			return null;
		return commentDao.selectCommentList(co_bd_num);
	}

}

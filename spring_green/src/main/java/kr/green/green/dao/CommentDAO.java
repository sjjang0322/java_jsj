package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("co_bd_num")Integer co_bd_num);

	
}

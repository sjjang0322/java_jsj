package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

}

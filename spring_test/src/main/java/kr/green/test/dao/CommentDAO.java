package kr.green.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("co_bd_num")Integer co_bd_num, @Param("cri")Criteria cri);

	int selectTatalCountComment(@Param("co_bd_num")Integer co_bd_num, @Param("cri")Criteria cri);

	CommentVO selectComment(@Param("co_num")Integer co_num);

	void deleteComment(@Param("co_num")Integer co_num);

}

package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);
	
}

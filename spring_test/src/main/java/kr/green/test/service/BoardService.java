package kr.green.test.service;

import java.util.List;

import kr.green.test.vo.BoardVO;

public interface BoardService {

	void registerBoard(BoardVO board);

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);
	
}

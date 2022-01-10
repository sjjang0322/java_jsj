package kr.green.test.service;

import java.util.List;

import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

public interface BoardService {

	void registerBoard(BoardVO board);

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);

	void deleteBoard(Integer bd_num, MemberVO user);	

	BoardVO getBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board);
	
}

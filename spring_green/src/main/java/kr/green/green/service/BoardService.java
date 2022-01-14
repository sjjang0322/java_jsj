package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(String type);

	BoardVO getBoardDetail(Integer bd_num);	

	void registerBoard(BoardVO board);

	void modifyBoard(BoardVO board, MemberVO user);

	void deleteBoard(Integer bd_num, MemberVO user);

	List<BoardVO> getAllBoardList();

}

package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;
import kr.green.green.dao.BoardDAO;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> getBoardList(String type) {		
		return boardDao.selectBoardList(type);
	}

	@Override
	public BoardVO getBoardDetail(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;			
		return boardDao.selectBoardDetail(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board) {		
		boardDao.registerBoard(board);
		return;
	}

	@Override
	public void modifyBoard(BoardVO board, MemberVO user) {
		
		BoardVO bd_board = boardDao.selectBoardDetail(board.getBd_num());
		if(bd_board == null)
			return;
		if(!bd_board.getBd_me_id().equals(user.getMe_id()))
			return;
		boardDao.modifyBoard(board);
		return;
	}
	
	
}

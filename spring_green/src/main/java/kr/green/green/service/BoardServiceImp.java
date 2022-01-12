package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.vo.BoardVO;
import kr.green.green.dao.BoardDAO;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> getBoardList(String type) {		
		return boardDao.selectBoardList(type);
	}
	
	
}

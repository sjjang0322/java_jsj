package kr.green.test.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;

public interface BoardService {

	void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception;

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer bd_num);

	void deleteBoard(Integer bd_num, MemberVO user);	

	BoardVO getBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums);

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(Criteria cri);
	
}

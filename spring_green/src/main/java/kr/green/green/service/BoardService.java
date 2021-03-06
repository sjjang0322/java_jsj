package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoardDetail(Integer bd_num);	

	void registerBoard(BoardVO board, List<MultipartFile> files);

	void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files, Integer[] fileNums);

	void deleteBoard(Integer bd_num, MemberVO user, List<MultipartFile> files2, Integer[] fileNums);

	List<BoardVO> getAllBoardList();

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(Criteria cri);

	LikesVO getLikes(LikesVO likes);

	void insertLikes(LikesVO likes);

	void updateLikes(LikesVO likes);

	String views(LikesVO likes, MemberVO user);
}

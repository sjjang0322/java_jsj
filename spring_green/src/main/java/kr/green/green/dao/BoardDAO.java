package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;



public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("type")String type, @Param("cri")Criteria cri);

	BoardVO selectBoardDetail(@Param("bd_num")Integer bd_num);

	void registerBoard(@Param("board")BoardVO board);

	void modifyBoard(@Param("board")BoardVO board);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	List<BoardVO> getAllBoardList();

	void insertFile(@Param("file")FileVO file);

	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

	void deleteFile2(@Param("file")FileVO tmp);

	int getTotalCount(@Param("cri")Criteria cri);




}

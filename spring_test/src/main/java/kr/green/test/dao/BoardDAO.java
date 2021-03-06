package kr.green.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);

	List<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void getBoard(@Param("bd_num")Integer bd_num, @Param("bd_user")MemberVO user);

	void updateBoard(@Param("board")BoardVO dbBoard);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

	int selectCountBoard(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

}

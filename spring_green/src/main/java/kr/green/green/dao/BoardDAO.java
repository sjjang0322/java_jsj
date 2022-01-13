package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;



public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("type")String type);

	BoardVO selectBoardDetail(@Param("bd_num")Integer bd_num);

	void registerBoard(@Param("board")BoardVO board);

	void modifyBoard(@Param("board")BoardVO board);


}
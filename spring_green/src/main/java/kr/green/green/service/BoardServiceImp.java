package kr.green.green.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;
import kr.green.green.dao.BoardDAO;
import kr.green.green.utils.UploadFileUtils;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Autowired
	BoardService boardService;
	
	String uploadPath = "D:\\JAVA_JSJ\\upload";
	
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
	public void registerBoard(BoardVO board, List<MultipartFile> files) {		
		boardDao.registerBoard(board);
		
		if(files == null || files.size() == 0)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				try {
					String path = UploadFileUtils.uploadFile(uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
					FileVO file = new FileVO(tmpFile.getOriginalFilename(),path,board.getBd_num());
					boardDao.insertFile(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
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

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
//		System.out.println("삭제 임플 시작");		
		BoardVO bd_board = boardDao.selectBoardDetail(bd_num);
//		System.out.println(list);
//		System.out.println(bd_num);
		if(bd_num<1||bd_num==null) {
//			System.out.println("삭제 다오 컷");
			return;
		}
		if(bd_board == null)
			return;
		if(user != null && user.getMe_id().equals(bd_board.getBd_me_id())) {
//			System.out.println("삭제 다오 시작");
			boardDao.deleteBoard(bd_num);
		}
		return;
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		return boardDao.getAllBoardList();
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num<=0 || bd_num == null)
			return null;
		return boardDao.selectFileList(bd_num);
	}
	
	
}

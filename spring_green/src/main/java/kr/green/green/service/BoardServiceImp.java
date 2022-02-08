package kr.green.green.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;
import kr.green.green.dao.BoardDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.utils.UploadFileUtils;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Autowired
	BoardService boardService;
	
	String uploadPath = "D:\\JAVA_JSJ\\upload";
	
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {		
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVO getBoardDetail(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;		
		boardDao.updateViews(bd_num);
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
	public void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files, Integer[] fileNums) {
		
		BoardVO bd_board = boardDao.selectBoardDetail(board.getBd_num());
		if(bd_board == null)
			return;
		if(!bd_board.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.modifyBoard(board);

		//해당 게시글 번호와 일치하는 첨부파일 전체를 가져옴
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		List<FileVO> remainFileList = new ArrayList<FileVO>();
 		//가져온 첨부파일전체에서 fileNums에 일치하는 번호가 있으면 remainFileList에 추가
		//유지해야할 첨부파일이 있는경우
		if(fileNums != null && fileNums.length != 0) {
			for(FileVO tmp : fileList) {
				for(Integer tmpNum: fileNums) {
					if(tmp.getFi_num() == tmpNum) {
						remainFileList.add(tmp);
					}
				}
			}
			//게시글의 전체 첨부파일중 유지해야할 첨부파일을 제외한 첨부파일 만듬
			fileList.removeAll(remainFileList);
		}

		
		deleteFile(fileList);
		uploadFile(files, board.getBd_num());
		
		
		
		return;
	}



	@Override
	public void deleteBoard(Integer bd_num, MemberVO user, List<MultipartFile> files2, Integer[] fileNums) {
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
			//첨부파일 삭제하기 위해서 해당 게시글과 일치하는 첨부파일들을 가져옴
			List<FileVO> fileList = boardDao.selectFileList(bd_num);
			
			deleteFile(fileList);
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
	
	private void uploadFile(List<MultipartFile> files, Integer bd_num) {
		System.out.println(files);
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				try {
					String path = UploadFileUtils.uploadFile(
						uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
					FileVO fileVo = 
							new FileVO(tmpFile.getOriginalFilename(), path, bd_num);
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}

	private void deleteFile(List<FileVO> fileList) {
		//실제 서버에서 삭제
		if(fileList != null && fileList.size()!=0) {
			for(FileVO tmp : fileList) {
				String fileName = tmp.getFi_name().replace("/",File.separator);
				File file = new File(uploadPath + fileName);
				boardDao.deleteFile2(tmp);
				if(file.exists()) {
					file.delete();
				}
			}
		}
	}

	@Override
	public int getTotalCount(Criteria cri) {		
		return boardDao.getTotalCount(cri);
	}

	@Override
	public LikesVO getLikes(LikesVO likes) {
		return boardDao.getLikes(likes);
	}

	@Override
	public void insertLikes(LikesVO likes) {
		if(likes==null)
			return;
		boardDao.insertLikes(likes);
	}

	@Override
	public void updateLikes(LikesVO likes) {
		if(likes==null)
			return;
		boardDao.updateLikes(likes);
	}


}

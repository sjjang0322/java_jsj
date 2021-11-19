package day18;

import java.util.*;

public class ExfBoardManager {
	private List<ExfBoard> boardList;
	private int count=0, index;
	private Scanner scan;
	Date date1 = new Date();
	
	
	public ExfBoardManager(Scanner scan, List<ExfBoard> boradList) {
		this.scan = scan;
		this.boardList = boradList;
	}
	
	public void inserBoard() {
		scan.nextLine();
		System.out.print("글제목 : ");
		String title = scan.nextLine();
		System.out.print("글내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		ExfBoard board = new ExfBoard(count, title, contents, writer);
		boardList.add(board);
		count++;
	}
	
	public void removeBoard() {
		scan.nextLine();
		for(int i=0;i<boardList.size();i++) {
			System.out.println(boardList.get(i).getNum()+1 + "번글 : " + boardList.get(i).getTitle());
		}
		System.out.print("삭제할 글 번호 : ");
		index = scan.nextInt()-1;
		ExfBoard tmp = new ExfBoard(index);
		boolean doit = false;
		for(int i=0;i<boardList.size();i++) {
			if(tmp.equals(boardList.get(i))){
				boardList.remove(i);
				doit = true;
			}
		}
		if(!doit) {
			System.out.println("번호를 잘못 입력했습니다.");
		}
	}
	
	public void displayBoard() {
		scan.nextLine();
		for(int i=0;i<boardList.size();i++) {
			System.out.println(boardList.get(i).getNum()+1 + "번글 : " + boardList.get(i).getTitle());
		}
		System.out.print("조회할 글 번호 : ");
		index = scan.nextInt()-1;
		ExfBoard tmp = new ExfBoard(index);
		boolean doit = false;
		for(int i=0;i<boardList.size();i++) {
			if(tmp.equals(boardList.get(i))){
				boardList.get(i).view();
				boardList.get(i).print();
				doit = true;
			}
		}
		if(!doit) {
			System.out.println("번호를 잘못 입력했습니다.");
		}
	}
	
	public void modifyBoard() {
		scan.nextLine();
		for(int i=0;i<boardList.size();i++) {
			System.out.println(boardList.get(i).getNum()+1 + "번글 : " + boardList.get(i).getTitle());
		}
		System.out.print("수정할 글 번호 : ");
		index = scan.nextInt()-1;
		scan.nextLine();
		ExfBoard tmp = new ExfBoard(index);
		boolean doit = false;
		for(int i=0;i<boardList.size();i++) {
			if(tmp.equals(boardList.get(i))){
				System.out.print("글제목 : ");
				String title = scan.nextLine();
				System.out.print("글내용 : ");
				String contents = scan.nextLine();
				boardList.get(i).setTitle(title);
				boardList.get(i).setContents(contents);
				boardList.get(i).setDate(date1.toString());
				doit = true;
			}
		}
		if(!doit) {
			System.out.println("번호를 잘못 입력했습니다.");
		}		
	}
}

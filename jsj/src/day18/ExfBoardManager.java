package day18;

import java.util.*;

public class ExfBoardManager {
	private List<ExfBoard> boardList;
	private int index;
	private Scanner scan;
	Date date;
	
	
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
		ExfBoard board = new ExfBoard(title, contents, writer);
		boardList.add(board);
	}
	
	public void displayBoard() {
		scan.nextLine();
		if(printTW()) {
			System.out.print("조회할 글 번호 : ");
			try{
				index = scan.nextInt()-1;
			}catch(InputMismatchException e){
				System.out.println("숫자를 입력해주세요(예 : 123)");
				scan.nextLine();
				return;
			}
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
		}else {
			System.out.println("조회 할 글이 하나도 없습니다.");
		}
	}
	
	public void removeBoard() {
		scan.nextLine();
		if(printTW()) {
			System.out.print("삭제할 글 번호 : ");
			try{
				index = scan.nextInt()-1;
			}catch(InputMismatchException e){
				System.out.println("숫자를 입력해주세요(예 : 123)");
				scan.nextLine();
				return;
			}
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
		}else {
			
		}
	}
		
	public void modifyBoard() {
		scan.nextLine();
		if(printTW()) {
			System.out.print("수정할 글 번호 : ");
			try{
				index = scan.nextInt()-1;
			}catch(InputMismatchException e){
				System.out.println("숫자를 입력해주세요(예 : 123)");
				scan.nextLine();
				return;
			}
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
					boardList.get(i).setDate(new Date());
					doit = true;
				}
			}
			if(!doit) {
				System.out.println("번호를 잘못 입력했습니다.");
			}		
		}else {
			System.out.println("수정 할 글이 하나도 없습니다.");
		}
	}
	
	public boolean printTW() {
		if(boardList.size()==0) {
			return false;
		}else {
			for(int i=0;i<boardList.size();i++) {
				System.out.println(boardList.get(i).getNum()+1 + "번글 : " + boardList.get(i).getTitle() + "	작성자 : " + boardList.get(i).getWriter());
			}
			return true;
		}
		
	}
}

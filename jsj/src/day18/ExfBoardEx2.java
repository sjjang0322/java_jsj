package day18;

import java.util.*;

public class ExfBoardEx2 {

	public static void main(String[] args) {
		/* 게시글을 관리하는 프로그램을 만드세요.
		 * 배열 X, 리스트 O
		 * 기능
		 * 1. 게시글 등록
		 * 2. 게시글 확인(전체)
		 * 3. 게시글 수정
		 * 4. 게시글 삭제 
		 * 5. 프로그램 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		List<ExfBoard> boardList = new ArrayList<ExfBoard>();
		String [] strMenu = {
			"1. 게시글 등록",
			"2. 게시글 확인",
			"3. 게시글 수정",
			"4. 게시글 삭제",
			"5. 프로그램 종료"
		};
		ExfBoardManager bm = new ExfBoardManager(scan, boardList);
		boolean in=true;
		do {
			switch(printMenu(scan, strMenu)) {
			case 1 : bm.inserBoard(); 
				break;
			case 2 : bm.displayBoard();
				break;
			case 3 : bm.modifyBoard();
				break;
			case 4 : bm.removeBoard();
				break;
			case 5 : in = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case -1 :
				System.out.println("숫자를 입력해주세요(예 : 123)");
				break;
			default : System.out.println("잘못된 번호를 입력하셨습니다.");
				break;
			}
		}while(in);	
	}
	
	public static int printMenu(Scanner scan,String [] strMenu) {
		try {
			System.out.println("----메뉴----");
			for(String tmp : strMenu) {
				System.out.println(tmp);
			}
			System.out.print("하고싶은 작업의 번호를 입력하세요 : ");
			int menu = scan.nextInt();
			return menu;
		}catch(InputMismatchException e) {
			scan.nextLine();
			return -1;
		}
	}
}

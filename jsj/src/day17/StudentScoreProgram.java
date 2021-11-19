package day17;

import java.util.*;

public class StudentScoreProgram {

	public static void main(String[] args) {
		/*- 학생 정보 추가
		 *- 학생 정보 출력(전체, 개인)
		 *- 학생 정보 수정
		 *- 학새 정보 삭제
		 *- 프로그램 종료
		 *- 유의 사항
		 *- 학생 정보 추가시 기존에 있는 학생(학년, 반, 번호가 일치하는 학생)인 경우 학생 정보를
    		추가하지 않음
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		int menu;
		
		System.out.println("----메뉴----");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 학생 정보 수정");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("하고 싶은 일의 번호를 입력하세요 : ");
		menu = scan.nextInt();
		
		switch(menu) {
		case 1 :
			break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			break;
		case 5 :
			break;
		}
		
		
	}
	
	public static void add(Scanner scan,ArrayList<ExbStudent> stdList) {
		ExbStudent std = new ExbStudent();
	}
}

package day12;

import java.util.Scanner;


public class ShapePro {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ShapeManager sm = new ShapeManager(scan);
		int menu;
		do {
			menu = menu(scan);
			switch(menu) {
			case 1: sm.draw(scan);
				break;
			case 2:	sm.redo();
				break;
			case 3: sm.undo();
				break;
			case 4: sm.print();
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}while(menu!=5);
	}
	//메뉴 출력
	public static int menu(Scanner scan) {
		int menu;
		System.out.println("----메뉴----");
		System.out.println("1. 도형그리기");
		System.out.println("2. 다시 실행");
		System.out.println("3. 실행 취소");
		System.out.println("4. 도형 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		menu = scan.nextInt();
		System.out.println("-----------");
		return menu;
	}
	//1번 메뉴 실행
	
}



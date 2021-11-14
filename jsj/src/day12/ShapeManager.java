package day12;

import java.util.Scanner;

import day10.Board;

public class ShapeManager {
	private ExaShape shapeList[];
	private ExaShape tmp;
	private Scanner scan;
	private int left, right, top, bottom;
	private int count;
	public ShapeManager(Scanner scan) {
		this(10,scan);
		//boardList = new Board[10];
		//this.scan = scan;
	}
	public ShapeManager(int size, Scanner scan) {
		this.scan = scan;
		if(size > 10) {
			shapeList = new ExaShape[size];
		} else {
			shapeList = new ExaShape[10];
		}
	}
	/*System.out.println("----메뉴----");
		System.out.println("1. 도형그리기");
		System.out.println("2. 다시 실행");
		System.out.println("3. 실행 취소");
		System.out.println("4. 도형 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		menu = scan.nextInt();
		System.out.println("-----------");
	 * 
	 */
	
	//도형 그리기
	public void draw(Scanner scan) {
		int shape;
		System.out.print("그릴 도형을 선택하세요(1.사각형, 2.타원) : ");
		shape = scan.nextInt();
		System.out.println("점 두개를 입력하세요 : ");
		left = scan.nextInt();
		top = scan.nextInt();
		right = scan.nextInt();
		bottom = scan.nextInt();
		switch(shape) {
		case 1 : System.out.println("사각형을 그렸습니다.");
				shapeList[count] = new ExaRect(left, top, right, bottom); 
				count++; 
				break;
		case 2 : System.out.println("타원형을 그렸습니다."); 
				shapeList[count] = new ExaEllipse(left, top, right, bottom); 
				count++;
				break;
		default : System.out.println("잘못입력하셨습니다.");
		}				
	}
	//실행 취소
	public void undo() {
		tmp = shapeList[--count];
		shapeList[count] = null;
	}
	//다시 실행
	public void redo() {
		shapeList[count] = tmp;
		count++;
	}
	//도형 확인
	public void print() {
		for(ExaShape tmp : shapeList) {
			if(tmp!=null) {
				tmp.print();
			}
		}
	}
	
}

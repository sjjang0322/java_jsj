package day3;

import java.util.Scanner;

public class ScoreEx2 {
	public static void main(String[] args) {
		/* 0~100점 사이의 점수를 입력받아 입력받은 점수의 학점을 출력하는 코드를 작성하세요.
		 * 90이상 100이하	 : A
		 * 80이상 90미만 	 : B
		 * 70이상 80미만 	 : C
		 * 60이상 70미만 	 : D
		 *  0이상 60미만	 : F
		 * 잘못된 점수	     : 잘못된 점수입니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력해 주세요 : ");
		int score = scan.nextInt();
		scan.close();
		
		switch(score/10) {
		case 10 :
			switch(score) {
			case 100 :
				System.out.println("학점 : A");
				break;
			default :
				System.out.println("잘못된 점수입니다.");
			}
			break;
		case 9 :
			System.out.println("학점 : A");
			break;
		case 8 :
			System.out.println("학점 : B");
			break;
		case 7 :
			System.out.println("학점 : C");
			break;
		case 6 :
			System.out.println("학점 : D");
			break;
		case 1,2,3,4,5 :
			System.out.println("학점 : F");
			break;
		case 0 :
			switch(score) {
			case 0,1,2,3,4,5,6,7,8,9:
				System.out.println("학점 : F");
				break;
			default :
				System.out.println("잘못된 점수입니다.");
				break;
			}
		default :
			System.out.println("잘못된 점수입니다.");
			break;
		}
		
	}
}

package day3;

import java.util.Scanner;

public class ScoreEx1 {
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
		
		if(score>100) {
			System.out.println("잘못된 점수입니다.");
		} else if(score>=90) {
			System.out.println("학점 : A");
		} else if(score>=80) {
			System.out.println("학점 : B");
		} else if(score>=70) {
			System.out.println("학점 : C");
		} else if(score>=60) {
			System.out.println("학점 : D");
		} else if(score>=0) {
			System.out.println("학점 : F");
		} else {
			System.out.println("잘못된 점수입니다.");
		}
		
	}
}

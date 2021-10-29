package day3;

import java.util.Scanner;

public class IfMonthEx1 {
	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 단, 2월은 28일로, 1월 : 31
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("몇월의 마지막 일을 알고싶으십니까? : ");
		int month = scan.nextInt();
		scan.close();
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + "월의 마지막 일은 31일 입니다.");
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "월의 마지막 일은 30일 입니다.");
		} else if(month == 2) {
			System.out.println(month + "월의 마지막 일은 28일 입니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}

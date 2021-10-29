package day3;

import java.util.Scanner;

public class SwitchMontEx1 {

	public static void main(String[] args) {
		/* 월의 마지막일을 출력하는 코드를 switch문으로 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 달을 입력하세요 : ");
		int month = scan.nextInt();
		scan.close();
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + "월의 마지막 날은 31일 입니다.");
			break;
		case 2:
			System.out.println(month + "월의 마지막 날은 28일 입니다.");
			break;
		case 4, 6, 9, 11:
			System.out.println(month + "월의 마지막 날은 30일 입니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}

}

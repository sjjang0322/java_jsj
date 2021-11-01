package day4;

import java.util.Scanner;

public class ForBreakEx1 {

	public static void main(String[] args) {
		/* 0을 입력할 때까지 정수를 계속 입력 받는 코드를 작성하세요.
		 * break문을 이용.
		 * 예)
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 112434
		 * 정수를 입력하세요 : 1235
		 * 정수를 입력하세요 : -135
		 * 정수를 입력하세요 : 0
		 * 종료합니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		int num;
		for(;;) {
			System.out.print("정수를 입력하세요 : ");
			num = scan.nextInt();
			if(num==0) {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}

}

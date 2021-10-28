package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		/* 콘솔에서 두 정수를 입력받아 입력받은 정수들의 합과 나눈결과를 구하는 코드를 작성하세요.
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("입력된 정수는 : " + num1 + "입니다.");
		
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println("입력된 정수는 : " + num2 + "입니다.");
		
		System.out.println("입력된 정수들의 합은 " + (num1 + num2) + "입니다.");
		System.out.println("입력된 정수들의 나눈 결과는 " + ((double)num1 / num2) + "입니다.");
		
		
	}

}

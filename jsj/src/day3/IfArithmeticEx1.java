package day3;

import java.util.Scanner;

public class IfArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연사자중 하나를 입력하여 
		 * 입력한 연산자가 +이면 두 정수의 합을 출력하는 코드를 작성하세요.
		 * 입력한 연산자가 -이면 두 정수의 차를 출력하는 코드를 작성하세요.
		 * 입력한 연산자가 *이면 두 정수의 곱을 출력하는 코드를 작성하세요.
		 * 입력한 연산자가 /이면 두 정수의 나눗셈을 출력하는 코드를 작성하세요.
		 * 입력한 연산자가 %이면 두 정수의 나머지를 출력하는 코드를 작성하세요.
		 * 산술연산자가 아니면 산술 연산자가 아닙니다라고 출력하는 코드를 작성하세요.
		 * 예시1)
		 * 두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : 1 + 2
		 * 1 + 2 = 3
		 * 예시2)
		 * 두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : 1 / 2
		 */
		
		Scanner scan = new Scanner(System.in); 
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.print("산술 연산자를 입력하세요 : ");
		char ari = scan.next().charAt(0);
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		scan.close();
		
		if(ari == '+') {
			System.out.println(num1 + " " + ari + " " + num2 + " = " + (num1 + num2));
		} else if(ari == '-') {
			System.out.println(num1 + " " + ari + " " + num2 + " = " + (num1 - num2));
		} else if(ari == '*') {
			System.out.println(num1 + " " + ari + " " + num2 + " = " + (num1 * num2));
		} else if(ari == '/') {
			System.out.println(num1 + " " + ari + " " + num2 + " = " + ((double)num1 / num2));
		} else if(ari == '%') {
			System.out.println(num1 + " " + ari + " " + num2 + " = " + (num1 % num2));
		} else {
			System.out.println(ari + "는 산술 연산자가 아닙니다");
		}
	}

}

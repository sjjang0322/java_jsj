package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExaArithmeticExceptionEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 단, 메소드를 이용하고, 예외처리를 하세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		try {			
			ari(scan);			
		}catch(ArithmeticException e){
			System.out.println("0으로 나눔");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘못함");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		scan.close();
	}
	
	public static void ari(Scanner scan) throws Exception{
		System.out.print("첫번째 정수 : ");
		int num1 = scan.nextInt();
		System.out.print("연산자 : ");
		char op = scan.next().charAt(0);
		System.out.print("두번째 정수 : ");
		int num2 = scan.nextInt();
		int res1=0;
		double res2=0.0;
		
		switch(op) {
		case '+' : res1 = num1 + num2;
			System.out.println(num1 + " + " + num2 + " = " + res1);
			break;
		case '-' : res1 = num1 - num2;
			System.out.println(num1 + " - " + num2 + " = " + res1);
			break;
		case '*' : res1 = num1 - num2;
			System.out.println(num1 + " * " + num2 + " = " + res1);
			break;
		case '/' : res2 = num1 / (double)num2;
			System.out.println(num1 + " / " + num2 + " = " + res2);
			break;
		case '%' : res1 = num1 % num2;
			System.out.println(num1 + " % " + num2 + " = " + res1);
			break;
		default : throw new Exception("연산자를 잘못 입력");
		}
	}

}

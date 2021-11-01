package day4;

import java.util.Scanner;

public class ForGCDEx2 {

	public static void main(String[] args) {
		/* 두 정수의 최대 공약수를 구하는 코드를 for문을 이용하여 작성하세요.
		 * 약수: 나누어서 떨어지는수
		 * 12의 약수 : 1 2 3 4 6 12
		 * 8의 약수 : 1 2 4 8
		 * 공약수 : 두 정수의 약수 중 공통으로 있는 약수
		 * 8과 12의 공약수 : 1 2 4
		 * 최대 공약수 : 두 정수의 공약수 중 가장 큰 수
		 * 8과 12의 최대 공약수 :  4
		 * 반족횟수 : i는 1부터 num1까지 1씩 증가
		 * 규칙성  : i가 num1의 약수이고, i가 num2의 약수이면 i를 출력
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		int gcd=0;
		for(int i = 1;i<=num1;i++) {
			if(num1%i==0)
				if(num2%i==0)
					gcd=i;
		}
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수는 " + gcd + "입니다.");
		
		
	}

}

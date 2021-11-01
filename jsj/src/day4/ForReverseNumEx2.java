package day4;

import java.util.Scanner;

public class ForReverseNumEx2 {

	public static void main(String[] args) {
		/* 정수를 역순으로 출력하는 코드를 for문으로 작성하세요.
		 * 예) 1234
		 * => 4321
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("양의 정수를 입력해 주세요 : ");
		int num = scan.nextInt();
		scan.close();
		int num2 = num;
		System.out.print("역순은 : ");
		for( ; ; ) {
			System.out.print(num%10);
			num=num/10;
			if(num==0)
				break;			
		}
		System.out.println();
		
		
		System.out.print("역순은 : ");
		for( ; num2 != 0 ; num2 = num2/10 ) {
			System.out.print(num2%10);
			
		}
	}

}

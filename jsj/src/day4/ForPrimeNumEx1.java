package day4;

import java.util.Scanner;

public class ForPrimeNumEx1 {

	public static void main(String[] args) {
		/* 입력받은 정수가 소수인지 아닌지 판별하는 코드를 for문을 이용하여 작성하세요.
		 * 소수는 약수가 2개인 수
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		int cnt = 0;
		for(int i = 1;i <= num ; i++) {
			if(num%i==0) {
				cnt++;
				if(cnt>2)
					break;
			}
		}
		if(cnt==2) {
			System.out.println(num + "은 소수입니다.");
		}	else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
	}

}

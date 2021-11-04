package day7;

import java.util.Scanner;

public class MethodPrimeNumEx1 {

	public static void main(String[] args) {
		/* 주어진 정수가 소수인지 아닌지 판별하는 메소드를 만들고 호출하여 확인하세요
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("소수인지 확인할 정수를 입력하세요 : ");
		int num = scan.nextInt();
		scan.close();
		
		
		System.out.println(num + "은 소수" + (isPrimeNum(num) ? "입니다." : "가 아닙니다"));
		
	}
	
	public static boolean isPrimeNum(int a) {
		int cnt = 0;
		if(a<=0) {
			return false;
		}
		for(int i = 1;i <= a ; i++) {
			if(a%i==0) {
				cnt++;
				if(cnt>2)
					break;
			}
		}
		if(cnt!=2) 
			return false;		
		return true;
	}
}

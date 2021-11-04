package day7;

import java.util.Scanner;

public class MethodGCDEx1 {

	public static void main(String[] args) {
		/* 최대 공약수를 구하는 메소드를 정의하고, 호출하여 최대 공약수를 출력하는 코드를 작성하세요.
		 * 최소 공배수를 구하는 메소드를 정의하고, 호출하여 최소 공배수를 출력하는 코드를 작성하세요.
		 */
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		scan.close();
		
		int gcd=GCD(num1,num2);
		
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수는 " + gcd + "입니다.");
		
		int lcm1=LCM1(num1,num2);
		
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수는 " + lcm1 + "입니다.");

		int lcm2=LCM2(num1,num2);
		
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수는 " + lcm2 + "입니다.");
		
		
	}
	
	public static int GCD(int a,int b) {
		int gcd=0;
		for(int i = 1;i<=a;i++) {
			if(a%i==0)
				if(b%i==0)
					gcd=i;
		}		
		return gcd;
	}
	
	public static int LCM1(int a,int b) {
		int lcm=0;
		for(int i=1;i<=a*b;i++) {
			if(i%a==0&&i%b==0) {
				lcm=i;
				break;
			}
		}
		return lcm;
	}
	
	public static int LCM2(int a,int b) {
		int lcm=a*b/GCD(a,b);
		
		return lcm;
	}
}

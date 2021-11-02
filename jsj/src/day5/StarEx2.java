package day5;

public class StarEx2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 반복문을 이용하여 코드를 작성하세요
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 i개 출력하고 엔터를 출력
		 * 			반복횟수 : j를 1부터 i까지 1씩 증가
		 * 			규칙성 : *을 출력
		 * 			엔터를 출력		 
		 */
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-----");
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-----");
		
		for(int i=5;i>=1;i--) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("-----");
		
		for(int i=3;i>=1;i--) {
			for(int j=3;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

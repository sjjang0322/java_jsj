package day5;

public class StarEx3 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 반복문을 이용하여 코드를 작성하세요
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 실행문 : 공백을 ??개 출력하고, *을 i개 출력하고, 엔터를 출력
		 * 			반복횟수 :
		 * 			실행문 : 공백을 출력
		 * 			반복횟수 : j를 1부터 i까지 1씩 증가
		 * 			실행문 : *을 출력
		 * 			엔터를 출력		 
		 */
		
		for(int i=1;i<=5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("---------");
		
		System.out.println("     *");
		for(int i=1;i<4;i++) {
			for(int j=2;j<7;j++) {
				for(int k=6;k>j;k--) {
					System.out.print(" ");
				}
				for(int k=1;k<=j*2-1;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		for(int i=1;i<5;i++) {
			System.out.println("    ***");
		}

	}

}

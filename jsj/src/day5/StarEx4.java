package day5;

public class StarEx4 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 반복문을 이용하여 코드를 작성하세요
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */
		int num=5;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* *****
		 * ****
		 * ***
		 * **
		 * *
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 *   *
		 *  ***
		 * *****
		 *  ***
		 *   *
		 */
		
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
		
		for(int i=1;i<=2;i++) {
			for(int j=3;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
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

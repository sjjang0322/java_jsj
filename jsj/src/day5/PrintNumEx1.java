package day5;

public class PrintNumEx1 {

	public static void main(String[] args) {
		/* 다음과 같이 출력하도록 코드를 작성하세요.
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 */
		
		int num=3;
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num;j++) {
				System.out.print((i-1)*num+j + " ");
			}
			System.out.println();
		}
		
	}

}

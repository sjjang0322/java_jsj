package day3;

public class ForEvenEx1 {

	public static void main(String[] args) {
		/* 1부터 10까지 짝수들만 코드를 for문을 이용하여 작성하세요.
		 * 출력 예시)
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10		 
		 */
		for(int i=0;i<5;) {
			System.out.print(++i*2 + " ");
		}
		System.out.println();
		for(int i=2;i<11;i=i+2) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0;i<10;) {
			if(++i%2==0) {
				System.out.print(i+ " ");
			}
		}
		
		
	}

}

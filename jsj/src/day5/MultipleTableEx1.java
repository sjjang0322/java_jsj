package day5;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/* 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요.
		 * 
		 */
		
		int i=1,j;
		//단을 2에서 9까지 증가
		while(i++<9) {
			//i단 출력하는 코드
			j=0;
			while(j++<9) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println(i + "단 끝");
		}
		
		
		System.out.println("---------------");
		
		for(i=2;i<10;i++) {
			for(j=1;j<10;j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println(i + "단 끝");
		}
	}

}

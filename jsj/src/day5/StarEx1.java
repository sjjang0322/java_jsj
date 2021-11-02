package day5;

public class StarEx1 {

	public static void main(String[] args) {
		/* 반복문을 이용하여 다음과 같이 출력되는 코드를 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 5번씩 출력
		 * 			반복횟수 : j는 1부터 5까지 1씩 증가
		 * 			규칙성 : *을 출력
		 * 			반복문 종료 후 : 엔터를 출력
		 */
		int i,j;
		for(i=0;i<3;i++) {
			for(j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------");
		i=0;
		while(i<3) {
			j=0;
			while(j<5) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}

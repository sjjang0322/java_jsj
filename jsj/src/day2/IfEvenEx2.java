package day2;

public class IfEvenEx2 {

	public static void main(String[] args) {
		/* num가 짝수이면 짝수라고 출력하는 코드를 작성하세요.
		 * 조건식 : num가 짝수이다
		 * 실행문 : 짝수라고 출력
		 */
		int num = 9;
		boolean isEven = num%2 == 0;
		if(isEven) {
			System.out.println(num + "는 짝수입니다.");
		} 
		if(!isEven) {
			System.out.println(num + "는 홀수입니다.");
		}
	}

}

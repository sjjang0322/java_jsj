package day3;

public class ForMultipleTableEx1 {
	public static void main(String[] args) {
		/* 구구단 7단을 출력하는 코드를 작성하세요.
		 * 출력 예시
		 * 7 X 1 = 7
		 * 7 X 2 = 14
		 * ...
		 * 7 X 9 = 63
		 */
		int num = 7;
		for(int i=0;i<9;) {
			System.out.println(num + " X " + ++i + " = " + (num*i));
		}
	}
}

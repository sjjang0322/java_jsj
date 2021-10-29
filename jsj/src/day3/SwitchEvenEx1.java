package day3;

public class SwitchEvenEx1 {

	public static void main(String[] args) {
		/* switch문을 이용하여 정수의 홀짝 여부를 판별하는 코드를 작성하세요.
		 *  
		 */
		
		int num = 12;
		
		
		switch(num%2) {
		case 0:
			System.out.println("짝수입니다.");
			//break;
		default:
			System.out.println("홀수입니다.");
	
		}
	}

}

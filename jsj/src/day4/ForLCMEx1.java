package day4;

public class ForLCMEx1 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 for문을 이용하여 작성하세요.
		 * a의 배수 : 어떤 정수를 a로 나누었을때 나머지가 0인 수들
		 * 4의 배수 : 4, 8, 12, 16, 20, ....
		 * 6의 배수 : 6, 12, 18, 24, ......
		 * 공배수	  : 두 정수의 배수 중 공통으로 있는 배수들
		 * 4와 6의 공배수 : 12, 24, 36, 48, .....
		 * 최소 공배수 : 두 정수의 공배수 중 가장 작은 수
		 * 4와 6의 최소 공배수 : 12
		 */
		int num1=4,num2=6;
		for(int i=1;i<=num1*num2;i++) {
			if(i%num1==0&&i%num2==0) {
				System.out.println(num1 + "과 " + num2 + "의 최소공배수는 " + i +"입니다."); 
				break;
			}
		}
		
		/* 방법2 : num1부터 시작해서 num1*num2까지 num1씩 증가
		 * 
		 */
		
		for(int i=num1;i<=num1*num2;i+=num1) {
			if(i%num2==0) {
				System.out.println(num1 + "과 " + num2 + "의 최소공배수는 " + i +"입니다."); 
				break;
			}
		}
	}

}

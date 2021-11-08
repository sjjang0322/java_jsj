package day9;

public class MethodArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자가 주어졌을 때 연산 결과를 출력하는 코드를 작성하세요.
		 * 단, 메소드를 이용하고, 연산자는 무조건 산술 연산자만 입력한다고 가정.
		 * +,-,/,*,%
		 */
		

		System.out.println(ari(1,2,'+'));
		System.out.println(ari(1,2,'-'));
		System.out.println(ari(1,2,'*'));
		System.out.println(ari(1,2,'/'));
		System.out.println(ari(1,2,'%'));
		
	}
	
	/* 기능 : 두 정수와 산술 연산자가 주어졌을 때 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수와 산술 연산자 => int num1, char op, int num2
	 * 리턴타입 : 산술 연산 결과 => 실수 => double 
	 * 메소드명 : ari
	 */
	public static double ari(int num1,int num2,char ch) {
		switch(ch) {
		case '+':
			return num1+num2;			
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/(double)num2;
		case '%':
			return num1%num2;
		default : return 0;
		}
		
	}

}

package day2;

public class ComparisonEx1 {

	public static void main(String[] args) {
		//성인 판별하는 예제.
		//나이는 만 나이라고 가정. 성인은 만 19세 이상
		int age = 20;
		boolean isAdult = age >= 19;
		
		System.out.println(age + "살은 성인인가? " + isAdult);
		
		//num1이 짝수이면 isEven이 true가, 홀수이면 isEven이 false가 되도록 코드를 작성해보세요.
		int num1 = 9;
		//num1을 2로 나누었을때 나머지가 0과 같다.
		boolean isEven = num1%2 == 0;
		boolean isOdd = num1%2 == 1;	//!isEven
		System.out.println(num1 + "은 짝수인가 ? " + isEven);
		System.out.println(num1 + "은 홀수인가 ? " + isOdd);
		
	}

}

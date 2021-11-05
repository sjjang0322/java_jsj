package day8;

import java.util.Random;

public class MethodRandomEx1 {

	public static void main(String[] args) {
		/* 1부터 10사이의 랜덤한 수를 생성하여 출력하는 코드를 작성하세요.
		 * 단 랜덤한 수를 메소드를 이용하여 생성하세요 
		 */
		
		System.out.println(rand());
		random1();
		System.out.println(random2());
		random3(1,10);
		System.out.println(random4(1,10));
	}
	
	public static int rand() {
		int r=0;
		Random rand = new Random();
		r = rand.nextInt(10)+1;
		return r;
	}
	
	/* 기능 1부터 10사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 :	없음
	 * 메소드명 : random1
	 */
	public static void random1() {
		int r = 0;
		Random rand = new Random();
		r = rand.nextInt(10)+1;
		System.out.println(r);
	}
	
	/* 기능 1부터 10사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 정수 => int
	 * 메소드명 : random2
	 */
	public static int random2() {
		int r = 0;
		Random rand = new Random();
		r = rand.nextInt(10)+1;
		return r;
	}
	
	/* 기능 min부터 max사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 매개변수 : 1(최솟값), 10(최대값) => int min, int max
	 * 리턴타입 : 없음
	 * 메소드명 : random3
	 */
	public static void random3(int min,int max) {
		int r = 0;
		Random rand = new Random();
		r = rand.nextInt(max-min+1)+min;
		System.out.println(r);
	}
	
	/* 기능 min부터 max사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 1(최소값), 10(최대값) => int min, int max
	 * 리턴타입 :	정수 => int
	 * 메소드명 : random4
	 */
	public static int random4(int min,int max) {
		int r = 0;
		Random rand = new Random();
		r = rand.nextInt(max-min+1)+min;
		return r;
	}
	
}

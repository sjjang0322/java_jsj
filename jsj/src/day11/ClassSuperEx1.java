package day11;

public class ClassSuperEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Parent1{
	private int x,y;
	public void print() {
		System.out.println("클래스 입니다.");
		System.out.println("x : " + x);
		System.out.println("y : " + y);
	}
	public Parent1(int x, int y) {
		this.x = x; this.y = y;
	}
	
	public Parent1() {}
	
}

class Child1 extends Parent1{

	public Child1(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	/* 클래스 안에  멤버 변수, 메소드, 생성자가 하나도 없으면
	 * 자동으로 기본 생성자가 생성되고,
	 * 기본 생성자 안에 부모 클래스의 기본 생성자가 호출된다.
	 * 이 때, 부모 클래스의 기본 생성자가 없는 경우 호출할 수 없어서 에러가 발생
	 */
	
}
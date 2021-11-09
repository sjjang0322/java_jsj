package day10;

public class Rect1 {
	//시작점과 가로 세로 길이가 주어졌을때
	private int x,y,a,b;

	Rect1(){}
	
	public Rect1(int x, int y, int a, int b) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getA() {
		return a;
	}



	public void setA(int a) {
		this.a = a;
	}



	public int getB() {
		return b;
	}



	public void setB(int b) {
		this.b = b;
	}



	public void printInfo() {
		System.out.println("----사각형----");
		System.out.println("시작점 : (" + x + ", " + y + ")");
		System.out.println("가로길이 : " + a);
		System.out.println("세로길이 : " + b);
		System.out.println("--------------");
	}
	
	//시작점 이동기능
	public void move(int x,int y) {
		this.x = x;
		this.y = y;
	}
	//사각형 크기 변경 기능
	public void resize(int a,int b) {
		this.a = a;
		this.b = b;
	}
	
}

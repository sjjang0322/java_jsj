package day10;

public class Ellipse1 {
	private int x,y,a,b;

	public Ellipse1() {}

	public Ellipse1(int x, int y, int a, int b) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	//타원형 정보 출력 기능
	public void printInfo() {
		System.out.println("----타원형----");
		System.out.println("시작점 : (" + x + ", " + y + ")");
		System.out.println("가로길이 : " + a);
		System.out.println("세로길이 : " + b);
		System.out.println("--------------");
	}
	//사각형 이동 기능(시작점을 이동)
	public void move(int x,int y) {
		this.x=x; this.y=y;
	}
	//사각형 크기 변경 기능
	public void resize(int a,int b) {
		this.a=a; this.b=b;
	}

	

}

package day10;

public class Rect2 {
	//양 끝점을 이용한 사각형(그림판기준 : 위의점 < 아래점)
	private int left; 	//왼쪽위 점의 x좌표
	private int top; 	//왼쪽위 점의 y좌표
	private int right;	//오른쪽아래 점의 x좌표
	private int bottom;	//오른쪽아래 점의 y좌표
	
	public Rect2() {}
	
	
	public Rect2(int left, int top, int right, int bottom) {
		super();
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	//사각형 정보 출력 기능
	public void printInfo() {
		System.out.println("----사각형2---");
		System.out.println("시작점 : (" + left + ", " + top + ")");
		System.out.println("가로길이 : " + (right-left));
		System.out.println("세로길이 : " + (bottom-top));
		System.out.println("--------------");
	}
	//사각형 이동 기능(시작점을 이동)
	public void move(int x,int y) {
		int a=right-left,b=bottom-top;
		left = x;	top = y;
		right = left + a; bottom = top + b;
	}
	//사각형 크기 변경 기능
	public void resize(int a,int b) {
		right = left + a; bottom = top + b;
	}
	
}

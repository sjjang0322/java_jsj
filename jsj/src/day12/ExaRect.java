package day12;

public class ExaRect extends ExaShape{
	/* 도형 클래스를 상속받아 사각형 클래스를 만드세요.
	 * 
	 */
	public ExaRect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	@Override
	public void print() {
		System.out.println("------사각형----------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("가로길이 : " + getWidth());
		System.out.println("세로길이 : " + getHeight());
		
	}
	public void testR() {
		System.out.println("사각");
	}
}

package day13;

public class ExfRect extends ExfShape {

	public ExfRect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void draw() {
		System.out.println("사각형입니다.");
	}

}

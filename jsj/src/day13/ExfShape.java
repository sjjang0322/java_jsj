package day13;
/* Draw 인터페이스를 구현한 ExfShape 클래스를 만드세요. */

public abstract class ExfShape implements ExfDraw {
	protected int left, top;		//왼쪽 위점
	protected int right, bottom;	//오른쪽 아래점
	
	//도형을 그릴 때 대각선점 2개가 필요
	public ExfShape(int x1, int y1, int x2, int y2) {
		left  = x1 < x2 ? x1 : x2;
		right = x1 < x2 ? x2 : x1;
		top	  = y1 < y2 ? y1 : y2;
		bottom= y1 < y2 ? y2 : y1;
	}
	//도형의 너비을 계산하는 기능
	public int getWidth() {
		return right - left;
	}
	//도형의 높이를 계산하는 기능
	public int getHeight() {
		return bottom - top;
	}
	//도형은 위치를 이동시킬 수 있다.(왼쪽 위의 점)
	@Override
	public void move(int left, int top) {
		this.right 	= left + getWidth();
		this.bottom = top + getHeight();
		this.left 	= left;
		this.top 	= top;
	}
	//도형은 크기를 바꿀 수 있다(방향은 마음대로)
	@Override
	public void resize(int width, int height) {
		if(width <=0 || height<=0) {
			System.out.println("잘못된 너비 또는 높이입니다.");
			return;
		}
		right 	= left + width;
		bottom	= top + height; 
				
	}
}

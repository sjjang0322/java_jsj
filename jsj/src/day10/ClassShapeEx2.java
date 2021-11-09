package day10;

public class ClassShapeEx2 {
	//타원을 나타내는 클래스를 생성하고, 타원 클래스의 객체를 만들고, 테스트하세요.
	//사각형 클래스를 참고
	public static void main(String[] args) {
		Ellipse1 el1 = new Ellipse1(0,0,10,20);
		
		el1.printInfo();
		el1.move(5, 10);
		el1.printInfo();
		el1.resize(20, 30);
		el1.printInfo();

	}

}

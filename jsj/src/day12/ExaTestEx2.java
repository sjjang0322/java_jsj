package day12;

public class ExaTestEx2 {

	public static void main(String[] args) {
		/* 사각형과 타원을 여러개 저장할 수 있는 배열을 만들어 보세요 
		 * 사각형과 타원을 합쳐서 최대 10개까지 저장하는 배열*/
		int size = 10;
		
		ExaShape list[] = new ExaShape[size];
		//타원 1개와 사각형 2개를 생성하여 배열에 저장
		//클래스 형변화, 자식=>부모클래스로 형변화, 자동클래스형변환
		list[0] = new ExaEllipse(10, 10, 20, 30);
		list[1] = new ExaRect(20, 30, 40, 50);
		list[2] = new ExaRect(45, 55, 65, 75);
		list[3] = new ExaShape(10, 10, 0, 0);
		//배열에 저장된 도형들을 그려보세요.(콘솔에 출력)
		//반복문을 이용하여 배열에 저장된 도형들을 콘솔에 출력해보세요(print()이용)
		/* NullPointerException : 객체가 없는데 객체의 기능을 사용하려고 할 때 발생
		 * 객체가 없다 ==> null
		 */
		
		for(ExaShape tmp : list) {
			/* 도형이 있으면 print()기능을 이용하여 출력하고,
			 * 도형이 없으면 아무것도 안함.
			 * 도형이 없다가 null인 이유
			 *  - 배열은 생성이 되면 타입에 맞는 초기값으로 초기화를 한다
			 *  - 참조변수는 null로 초기화
			 *  - 도형이 없다는 건 도형이 생성되어 저장된게 아니기 때문에 초기값인 경우이다 
			 */
			if(tmp!=null) {
				tmp.print();
			} 
		}
		/* 저장된 도형이 타원이면 testE()를 호출하고, 사각형이면 testR()을 호출하세요.
		 * 반복문을 이용
		 */
		for(ExaShape tmp : list) {
			//도형이 타원이면 testE()를 호출
			if(tmp instanceof ExaEllipse) {
				// 도형 tmp를 타원으로 형변환 시킨후 testE()를 호출
				((ExaEllipse) tmp).testE();
				//ExaEllipse e = (ExaEllipse)tmp;
				//e.testE();
			}
			if(tmp instanceof ExaRect) {
				((ExaRect) tmp).testR();
			}
		}
		for(ExaShape tmp : list) {
			print(tmp);
		}
	}

	/* 기능 : 매개변수가 사각형이면 사각형이라고 출력하고, 매개변수가 타원이면 타원이라고 출력하고,
	 * 		  매개변수가 도형이면 도형이라고 출력하는 메소드
	 * 매개변수 : 사각형 또는 타원 또는 도형 =>
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print
	 */
	
	public static void print(ExaShape list) {
		if(list!=null) {
			if(list instanceof ExaEllipse) {
				System.out.println("타원입니다.");
				return;
			}
			if(list instanceof ExaRect) {
				System.out.println("사각형입니다.");
				return;
			}
			
			System.out.println("도형입니다.");
			return;
		}
	}
	
	
}

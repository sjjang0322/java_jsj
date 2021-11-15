package day14;

public class ExaStringEx2 {

	public static void main(String[] args) {
		/* 5명의 이름을 저장하고, 저장된 이름중 홍길동이 있는지 확인하세요.
		 */
		
		String name[] = new String[] {"홍길동", "안중근", "홍길동이", "김홍길동", "홍진호"};
		int count=0;
		for(String tmp : name) {
			if(tmp == "홍길동") {
				count++;
			}
		}
		if(count==0) {
			System.out.println("홍길동이 없습니다.");
		} else {
			System.out.println("홍길동이 " + count + "명 있습니다.");
		}
		count=0;
	
	}

}

package day14;

public class ExaStringEx1 {
	public static void main(String[] args) {
		/* 5명의 이름을 배열에 저장하고, 성이 홍씨인 사람을 검색하는 코드를 작성하세요. */
		
		String name[] = new String[] {"홍길동", "안중근", "유관순", "엄홍길", "홍진호"};
		for(String tmp : name) {
			if(tmp.startsWith("홍")) {
				System.out.println(tmp + "는 홍씨입니다.");
			} else {
				System.out.println(tmp + "는 홍씨가 아닙니다.");
			}
		}
		for(String tmp : name) {
			if(tmp.charAt(0) == '홍') {
				System.out.println(tmp + "는 홍씨입니다.");
			} else {
				System.out.println(tmp + "는 홍씨가 아닙니다.");
			}
		}
		for(String tmp : name) {
			if(tmp.indexOf("홍") == 0) {
				System.out.println(tmp + "는 홍씨입니다.");
			} else {
				System.out.println(tmp + "는 홍씨가 아닙니다.");
			}
		}
		
	}
}

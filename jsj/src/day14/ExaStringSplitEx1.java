package day14;

public class ExaStringSplitEx1 {

	public static void main(String[] args) {
		/* String [] split(String regex)
		 *	- 문자열에서 구분자를 기준으로 배열을 만들어 주는 메소드
		 *	- 매개변수는 문자열인데, 여기에 정규표현식을 넣을 수 있다.
		 *	- 정규표현식은 나중에 살펴볼 예정
		 *	- 정규표현식은 문자열에 패턴이 있는지 확인하는 식
		 * 
		 *  */
		String str = "Apple, Orange, Banana";
		String [] fruit = str.split(",");
		for(String tmp : fruit) {
			System.out.println(tmp.trim());
		}
		System.out.println(str);
		
		/*	boolean endWidth(String suffix)
		 * 	 -	문자열 끝부분이 suffix로 끝나는지 알려주는 매소드로
		 * 		suffix로 끝나면 true, 아니면 false로 알려줌
		 */
		String img1 = "flower.jpg";
		if(img1.endsWith(".jpg") || img1.endsWith(".bmp")) {
			System.out.println(img1 + "은 이미지 파일입니다.");
		} else {
			System.out.println(img1 + "은 이미지 파일이 아닙니다.");
		}
		/* boolean startsWidth(String prefix)
		 * 	= 문자열 시작부분이 prefix로 시작하는지 알려주는 메소드로
		 * 	  prefix로 시작하면 true, 아니면 false를 알려줌
		 */
		
		String fileName[] = new String[2];
		fileName[0] = "ExaStringReplaceEx1.java";
		fileName[1] = "ExaStringSplitEx1.java";
		for(String tmp : fileName) {
			if(tmp.startsWith("Exa")) {
				System.out.println(tmp + "는 첫번째 예제들입니다.");
			} else {
				System.out.println(tmp + "는 첫번재 예제가 아닙니다.");
			}
		}
		/* \n : 엔터, \t : 탭키를 누른 공백(일반적으로 4칸) */
		String strTrim = "\n\t\tapc\n\nabc\n\n";
		System.out.println(strTrim);
		System.out.println("----------");
		System.out.println(strTrim.trim());
		
		
	}

}

package day7;

public class MethodStarEx1 {

	public static void main(String[] args) {
		/* 다음을 출력하는 메소드를 만들고, 호출하여 테스트해보세요.
		 * *****
		 * ********
		 * -----
		 */
		
		printout('*',5);
		printout('*',8);
		printout('-',5);
	}
	

	
	public static void printout(char ch,int a) {
		for(int i=0;i<a;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	
}

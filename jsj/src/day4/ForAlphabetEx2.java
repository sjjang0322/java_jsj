package day4;

public class ForAlphabetEx2 {
	public static void main(String[] args) {
		/* 'a'부터 'z'까지 출력하는 코드를 for문으로 작성하세요.
		 * abcd.....xyz
		 * */
		
		for(int i=0;i<26;i++) {
			System.out.print((char)(i+97));
		}
		System.out.println();
		for(char i='a';i<='z';i++) {
			System.out.print(i);
		}
	}
}

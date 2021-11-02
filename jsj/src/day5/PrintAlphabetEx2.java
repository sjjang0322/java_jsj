package day5;

public class PrintAlphabetEx2 {

	public static void main(String[] args) {
		/* a
		 * ab
		 * abc
		 * abcd
		 * ....
		 * abcd...xyz
		 * 가 출력되도록 코드를 작성하세요 
		 *
		 */
		
		for(char ch='a';ch<='z';ch++) {
			for(char ch2='a';ch2<=ch;ch2++)
				System.out.print(ch2);
			System.out.println();
		}
		System.out.println("-------------------");
		for(char ch='z';ch>='a';ch--) {
			for(char ch2='a';ch2<ch;ch2++)
				System.out.print(" ");
			for(char ch2=ch;ch2<='z';ch2++)
				System.out.print(ch2);
			System.out.println();
		}
		
		
	}

}

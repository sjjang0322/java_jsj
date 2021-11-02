package day5;

public class PrintAlphabetEx1 {

	public static void main(String[] args) {
		/* zyx....cba 가 출력되도록 코드를 작성하세요.
		 * 
		 */
		
		for(char apb='z';apb>='a';apb-- )
			System.out.print(apb);
		
		System.out.println();
		
		int apbi = 'z';
		int apba = 'a';
		for(;apbi>=apba;apbi--)
			System.out.print((char)apbi);
		
	}

}

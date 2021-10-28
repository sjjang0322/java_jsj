package day2;

public class IfNumEx1 {

	public static void main(String[] args) {
		/* num가 0보다 크면 양수라고 출력하고
		 * num가 0이면 0이라고 출력하고
		 * num가 0보다 자긍면 음수라고 출력하는 코드를 작성하세요. 
		 */
		
		int num = -1;
		
		if(num>0) {
			System.out.println(num + "은 양수입니다.");
		} else if(num==0) {
			System.out.println(num + "은 0입니다.");
		} else {
			System.out.println(num + "은 음수입니다.");
		}
	}

}

package day13;

public class ExgStringCompareToEx2 {

	public static void main(String[] args) {
		/* 문자열 4개를 한곳에서 관리할 수 있게 배열을 만드세요. */
		int size=4;
		String str[] = new String[size];
		/* 배열에 b d a c 순으로 저장하세요. */
		str[0] = "b";
		str[1] = "d";
		str[2] = "a";
		str[3] = "c";
		/* 반복문과 compareTo를 이용하여 사전순으로 정렬해보세요. */
		for(int i=0;i<size-1;i++) {
			for(int j=0;j<size-1-i;j++) {
				String tmp;
				if(str[j].compareTo(str[j+1])>0) {
					tmp = str[j];
					str[j] = str[j+1];
					str[j+1] = tmp;
				}					
			}
		}
		
		for(String tmp1 : str) {
			System.out.println(tmp1);
		}
		
		
	}

}

package day6;

public class ArraySumEx1 {

	public static void main(String[] args) {
		/* 2부터 10사의의 짝수들을 배열에 저장하고, 배열에 저장된 값의 합을 출력하는 코드를 작성하세요.
		 * 
		 */
		int cnt = 0, ns = 2, nf = 10;
		
		for(int i=ns;i<=nf;i++) {
			if(i%2==0)
				cnt++;
		}
		
		int[] even = new int[cnt];
		
		
		cnt=ns;
		for(int i=0;i<even.length;cnt++) {
			if(cnt%2==0) {
				even[i]=cnt;
				i++;
			}
		}
		
		int sum = 0;
		for(int i=0;i<even.length;i++) {
			sum+=even[i];
		}
		System.out.println(sum);
		
		
	}

}

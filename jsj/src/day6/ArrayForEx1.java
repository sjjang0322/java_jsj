package day6;

public class ArrayForEx1 {

	public static void main(String[] args) {
		/* 
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
		for(int tmp : even) {
			sum+=tmp;
		}
		System.out.println(sum);
		
	}

}

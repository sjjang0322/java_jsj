package day5;

public class PrimeNumEx1 {

	public static void main(String[] args) {
		/* 2부터 100이하의 모든 소수를 출력하는 예제
		 * 소수 판별 예제 참고.
		 */
		System.out.print("2이상 100이하의 소수 : ");
		int num=2;
		while(num<=100) {
			int i=1;
			int cnt=0;
			while(i<=num) {
				if(num%i==0) {
					cnt++;
					if(cnt>2)
						break;
				}
				i++;
			}
			if(cnt==2) {
				System.out.print(num + " ");
			}
			num++;
		}
		
	}

}

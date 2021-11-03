package day6;

public class ArraySortEx1 {

	public static void main(String[] args) {
		//다음과 같은 배열이 있을 때 정렬하는 코드를 작성하세요.
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		/*버블정렬 : 옆에 있는 값과 비교하여 정렬하는 방법
		 * 1, 10, 9, 3, 6, 2, 3, 4
		 */
		int tmp;
		for(int i=0; i<num.length-1; i++) {
			for(int j=0; j<num.length-i-1; j++) {
				if(num[j]>num[j+1]) {
					tmp=num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
				}
			}
		}
		
		System.out.print("num : " );
		for(int tmp2 : num) {
			System.out.print(tmp2 + " ");
		}
	}

}

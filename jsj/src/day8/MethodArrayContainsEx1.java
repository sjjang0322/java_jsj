package day8;

import java.util.Arrays;

public class MethodArrayContainsEx1 {

	public static void main(String[] args) {
		/* 배열이 다음과 같이 주어지고, 정수가 주어졌을 때 정수가 배열에 있는 값인지 아닌지 확인하는 메소드를 정의하고,
		 * 호출하여 확인하세요.
		 * 
		 * 배열에 1~45사이의 랜덤한 수를 생성하여 저장하는 코드를 작성하세요.
		 * 단, 중복 불가, 메소드 이용
		 */
		
		int[] lotto;
		int min=1,max=45,size=6;
		lotto = randNum(min,max,size);
		System.out.println(Arrays.toString(lotto));
		int num = 40;
		
		
		System.out.println(num + "은 " + "lotto" + "안에 " + (isBe(lotto,num) ? "있습니다." : "없습니다."));
		
		System.out.println(num + "은 " + "lotto" + "안에 " + (isBe2(lotto,num,1) ? "있습니다." : "없습니다."));
	}

	public static boolean isBe(int[] arr, int a) {
		for(int i=0;i<arr.length;i++){
			if(arr[i]==a) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean isBe2(int[] arr, int a, int n) {
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
		//아니면 원래 검사 개수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i=0;i<n;i++){
			if(arr[i]==a) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] randNum(int min,int max,int size) {
		int[] arr = new int[size];
		for(int count=0; count < size ;	) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!isBe2(arr,random,count)) {
				arr[count++] = random;
			}
		}
		return arr;
	}
	
	
}	

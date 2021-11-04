package day7;

import java.util.Random;

public class ArrayRandomEx1 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 3개 생성하여 배열에 저장하는 코드를 작성하세요.
		 * 
		 */
		//3개짜리 배열을 생성
		int arr[] = new int[3];
		Random r = new Random();
		//3번 반복
		for(int i=0;i<3;i++) {
			//랜덤한 수를 생성
			int random = r.nextInt(9)+1;
			//배열에 랜덤한 수를 저장
			arr[i]= random;
		}
		//배열을 출력
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}

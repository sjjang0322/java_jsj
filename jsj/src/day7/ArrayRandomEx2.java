package day7;

import java.util.Random;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 3개 생성하여 배열에 저장하는 코드를 작성하세요.
		 * 단, 중복되지 않게
		 */
		//3개짜리 배열을 생성
		int arr[] = new int[3];
		int count = 0;
		Random r = new Random();
		//3번 반복
		do {
			//랜덤한 수를 생성
			int random = r.nextInt(9)+1;
			//배열에 중복된 값이 있는지 확인하는 반복문
			int i;
			/* count가 0, 반복문이 한번도 실행 안됨
			 * count가 1, 중복된 수가 있으면 반복문 종료후 i는 0 
			 * count가 2, 중복된 수가 있으면 반복문 종료후 i는 0 or 1
			 */
			for(i=0;i<count;i++) {
				//중복된 수가 있으면 반복문을 중단
				if(arr[i]==random) {
					break;
				}
			}
			//반복문 종료후 i값이 count와 같다는건 중복된 수가 없어서 break문이 실행 안된 경우
			if(i == count) {
				arr[i] = random;
				count++;
			}
			
		} while (count!=3);
		//배열을 출력
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}

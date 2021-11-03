package day6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayBaseballEx2 {

	public static void main(String[] args) {
		/* 숫자 야구 게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세수를 선택하고,
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * => 사용자가 처음으로 입력한 중복되지 않은 1~9사이의 세 수를 컴퓨터가 만든 수라고 가정하고,
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * 규칙
		 * S : 숫자가 있고, 숫자의 위치가 맞은 경우
		 * B : 숫자는 있지만 위치가 안 맞는 경우
		 * 3O: 맞는 숫자가 하나도 없는 경우
		 * 3S: 게임 종료
		 * 컴퓨터 : 1 9 5
		 * 사용자 : 1 2 3
		 * 1S
		 * 사용자 : 1 4 5
		 * 2S
		 * 사용자 : 1 5 8
		 * 1S1B
		 * 사용자 : 5 7 8
		 * 1B
		 * 사용자 : 4 7 8
		 * 3O
		 * 사용자 : 1 9 5
		 * 3S
		 * 정답입니다. 프로그램 종료.		
		 */
		//사용자가 컴퓨터 숫자 3개를 입력
		
		int arr[] = new int[3];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		/*
		System.out.print("컴퓨터 : " );
		for(int i=0;i<arr.length;i++) {
			arr[i] = scan.nextInt();
		}
		*/
		
		for(int i=0;i<arr.length;i++) {
			for(;;) {
				arr[i] = rand.nextInt(8)+1;
				int cnt=0;
				for(int j=0;j<i;j++) {
					if(arr[j]!=arr[i])
						cnt++;
				}
				if(cnt==i)
					break;
			}
		}
		
		int arr2[] = new int[arr.length];
		do {
			System.out.print("사용자 : ");
			for(int i=0;i<arr2.length;i++) {
				arr2[i] = scan.nextInt();
			}
			
			int cntS = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==arr2[i])
					cntS++;
			}
			
			if(cntS!=0) {
				System.out.print(cntS + "S");
				if(cntS==3) {
					System.out.println();
					System.out.println("정답입니다. 프로그램 종료");
					break;
				}
			}
			
			int cntB = 0;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr2.length;j++) {
					if(arr[i]==arr2[j]&&i!=j)
						cntB++;
				}
			}
			
			if(cntB!=0) {
				System.out.print((cntB) + "B");
			}
			
			if(cntS==0&&cntB==0)
				System.out.print("3O");
			
			System.out.println();
			
		} while(true);		
		scan.close();
		
	}

}

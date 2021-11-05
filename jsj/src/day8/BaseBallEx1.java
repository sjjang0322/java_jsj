package day8;

import java.util.Random;
import java.util.Scanner;

public class BaseBallEx1 {

	public static void main(String[] args) {
		/* 7일차 숫자 야구게임 예제와 lotto예제를 이용하여 숫자 야구 게임을 작성하세요.
		 * 단, 메소드를 생성하여, 컴퓨터가 생성하는 번호는 랜덤으로 중복되지 않게
		 */
		Scanner scan = new Scanner(System.in);


		
		int arr[] = new int[3];
		
		//정답 작성
		arr = randNum(1,9,3);
		
		int arr2[] = new int[arr.length];
		
		//답안 입력
		answer(arr,arr2,scan);
		
		scan.close();
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
	
	public static int cntS(int []arr,int[] arr2) {
		int cntS = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==arr2[i])
				cntS++;
		}
		return cntS;
	}
	
	public static int cntB(int[] arr,int[] arr2) {
		int cntB = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr[i]==arr2[j]&&i!=j)
					cntB++;
			}
		}
		return cntB;
	}
	
	public static void printOut(int s,int b) {
		//스트라이크 출력
		if(s!=0) {
			System.out.print(s + "S");
			if(s==3) {
				System.out.println();
				System.out.println("정답입니다. 프로그램 종료");
				return;
			}
		}
		//볼 출력
		if(b!=0) {
			System.out.print((b) + "B");
			return;
		}
		//3아웃 출력
		if(s==0&&s==0)
			System.out.print("3O");
		return;
		
	}
	
	public static void answer(int[] arr,int[] arr2, Scanner scan) {
		for(;;) {		
			System.out.print("사용자 : ");
			for(int i=0;i<arr2.length;i++) {
				arr2[i] = scan.nextInt();
			}
			//스트라이크 판별
			int cntS = cntS(arr,arr2);
			
			
			//볼 판별
			int cntB = cntB(arr,arr2);
			
			
			//출력 부문
			printOut(cntS,cntB);
			if(cntS==3) {
				break;
			}
			System.out.println();

		}		
		
	}
}

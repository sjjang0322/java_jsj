package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcExceptionEx1 {

	public static void main(String[] args) {
		/* 정수 5개짜리 배열에 정수를 5개 입력받아 저장한 후
		 * 원하는 번지의 정수를 수정하는 코드를 작성하세요.
		 * 예외 처리를 이용해보세요
		 * 예시)
		 * 정수를 5개 입력하세요 (예 : 1 2 3 4 5 ) : 1 2 3 4 5
		 * 수정할 번지와 수정할 정수를 입력하세요 : 0 5
		 * 5 2 3 4 5
		 * 수정할 번지와 수정할 정수를 입력하세요 : 6 5
		 * 잘못된 번지입니다. 
		 * 수정할 번지와 수정할 정수를 입력하세요 : -1 5
		 * 프로그램을 종료합니다.
		 */
		Scanner scan = new Scanner(System.in);
		int size = 5;
		int arr[] = new int[size];
		int num1,num2;
		try {
			input(scan,arr);
			
			do {
				System.out.println("수정할 번지와 수정할 정수를 입력하세요 : ");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				try {
					edit(scan, arr, num1, num2);
				}catch (InputMismatchException e) {
	
				}catch (ArrayIndexOutOfBoundsException e) {
					//e.printStackTrace();
					System.out.println("잘못된 번지입니다.");
				}catch (Exception e) {
					
				}
				
			} while(num1!=-1);
			System.out.println("프로그램을 종료합니다.");
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static void edit(Scanner scan, int arr[],int num1,int num2) throws ArrayIndexOutOfBoundsException,Exception {
		switch(num1) {
		case 0,1,2,3,4 : arr[num1] = num2;
						 for(int tmp : arr) {
							 System.out.print(tmp + " ");
						 }
						 System.out.println();
						 break;
		case -1 : throw new InputMismatchException("-1을 입력했습니다.");
		default : throw new ArrayIndexOutOfBoundsException("잘못된 번지입니다.");
		}
	}
	
	public static void input(Scanner scan,int arr[]) {
		//배열이 없으면 배열이 없다고 예외를 발생
		if(arr == null) {
			throw new NullPointerException("배열이 만들어지지 않았습니다.");
		}
		if(scan == null) {
			throw new NullPointerException("스캐너가 만들어지지 않았습니다.");
		}
		//배열의 크기만큼 반복하여 정수를 입력받아 저장
		System.out.print("정수를 " + arr.length + "개 입력하세요 : ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=scan.nextInt();
		}
	}
}

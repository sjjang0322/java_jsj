package day8;

import java.util.Arrays;
import java.util.Random;

public class MethodRandomArrayEx1 {

	public static void main(String[] args) {
		/* 1에서 45사이의 랜덤한 수를 6개 생성하여 배열에 저장하고, 출력하는 코드를 작성하세요
		 * 메소드를 생성하고 호출할 것.
		 */
		int min=1,max=45,num=6;
		System.out.println(Arrays.toString(rand(min,max,num)));
		
		int arr[] = new int[num];
		rand2(arr,min,max);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] rand(int min,int max,int num) {
		int arr[] = new int[num];
		Random rand = new Random();
		
		for(int i=0;i<num;i++) {
			arr[i] = rand.nextInt(max-min+1)+min; 
		}
			
		return arr;
	}
	
	public static void rand2(int[] arr,int min,int max) {
		Random rand = new Random();
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = rand.nextInt(max-min+1) + min; 
		}
	}

}

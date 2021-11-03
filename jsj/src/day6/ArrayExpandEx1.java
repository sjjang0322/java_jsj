package day6;

import java.util.Arrays;

public class ArrayExpandEx1 {

	public static void main(String[] args) {
		// 배열을 확장해야 하는 예제
		int score1[] = { 100, 90, 94, 60, 40};
		int score2[] = new int[score1.length+1];
		
		System.arraycopy(score1, 0, score2, 0, score1.length);
		score2[5] = 80;
		score1 = score2;
		score2 = null;
		System.out.println(Arrays.toString(score1));
		
		
		

	}

}

package day6;

import java.util.Scanner;

public class ArrayScoreAverageEx1 {

	public static void main(String[] args) {
		/* 배열을 이용하여 5명의 학생의 국어 성적을 입력받아 평균을 구하는 코드를 작성하세요.
		 * 단 성적을 배열에 저장해야 하고, 성적은 정수입니다.
		 */
		
		int score[] = new int[5];
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<score.length;i++) {
			System.out.print((i+1) + "번째 학생의 성적 : ");
			score[i] = scan.nextInt();
		}
		
		int sum=0;
		double avr;
		
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
		}
		avr = (double)sum/score.length;
		
		System.out.println("학생들의 평균 : " + avr);
		scan.close();
	}

}

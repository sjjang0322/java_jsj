package day9;

import java.util.Scanner;

public class ClassScoreEx1 {

	public static void main(String[] args) {
		/* 국어 , 영어, 수학 성적을 관리하기 위한 클래스를 만들고,
		 * 학생 5명의 성적을 관리하기 위한 배열을 만드세요.
		 */
		int size = 5;
		//5명의 학생 정보를 저장할 수 있는 배열을 생성
		StudentScore std[] = new StudentScore[size];
		Scanner scan = new Scanner(System.in);

		for(int i=0;i<size;i++) {
			int scoreK=0,scoreE=0,scoreM=0;
			String name;
			
			System.out.println(i+1 +"번째 학생 성적 입력");
			System.out.print("이름 : ");
			name = scan.next();
			System.out.print("국어 : ");
			scoreK = scan.nextInt();
			System.out.print("영어 : ");
			scoreE = scan.nextInt();
			System.out.print("수학 : ");
			scoreM = scan.nextInt();
			//new를 통해 학생 정보를 생성하고 생성자로 초기화			
			std[i] = new StudentScore(scoreK,scoreE,scoreM,name);
		}
		
		for(int i=0;i<size;i++) {
			std[i].printInfo();
		}
		int sumK=0;
		for(int i=0;i<size;i++) {
			sumK+=std[i].getScoreK();
		}
		System.out.println("국어 평균 : " + sumK/size);
		int sumE=0;
		for(int i=0;i<size;i++) {
			sumE+=std[i].getScoreE();
		}
		System.out.println("영어 평균 : " + sumE/size);
		int sumM=0;
		for(int i=0;i<size;i++) {
			sumM+=std[i].getScoreM();
		}
		System.out.println("수학 평균 : " + sumM/size);
		scan.close();
	}

}

class StudentScore{
	
	private int scoreK, scoreE, scoreM;
	private String name;
	
	public StudentScore() {
	}
	
	
	public StudentScore(int scoreK, int scoreE, int scoreM, String name) {
		super();
		this.scoreK = scoreK;
		this.scoreE = scoreE;
		this.scoreM = scoreM;
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScoreK() {
		return scoreK;
	}

	public void setScoreK(int scoreK) {
		this.scoreK = scoreK;
	}

	public int getScoreE() {
		return scoreE;
	}

	public void setScoreE(int scoreE) {
		this.scoreE = scoreE;
	}

	public int getScoreM() {
		return scoreM;
	}

	public void setScoreM(int scoreM) {
		this.scoreM = scoreM;
	}
	
	//학생 정보를 출력하는 메소드
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + scoreK);
		System.out.println("영어 : " + scoreE);
		System.out.println("수학 : " + scoreM);
	}
	
	
}
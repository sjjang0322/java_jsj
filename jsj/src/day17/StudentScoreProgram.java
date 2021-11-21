package day17;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentScoreProgram {

	public static void main(String[] args) {
		/*- 학생 정보 추가
		 *- 학생 정보 출력(전체, 개인)
		 *- 학생 정보 수정
		 *- 학새 정보 삭제
		 *- 프로그램 종료
		 *- 유의 사항
		 *- 학생 정보 추가시 기존에 있는 학생(학년, 반, 번호가 일치하는 학생)인 경우 학생 정보를
    		추가하지 않음
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		int menu=0;
		do {
			System.out.println("----메뉴----");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("하고 싶은 일의 번호를 입력하세요 : ");
			try {
				menu = scan.nextInt();
				switch(menu) {
				case 1 : add(scan,stdList);
					break;
				case 2 : printInfo(scan, stdList);
					break;
				case 3 : modify(scan, stdList);
					break;
				case 4 : remove(scan, stdList);
					break;
				case 5 :
					break;
				}
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("잘못 입력하셨습니다.");
			}catch(Exception e) {
				scan.nextLine();
				System.out.println("잘못 입력하셨습니다.");
			}
		}while(menu!=5);
		
			
		
	
		
		System.out.println("프로그램 종료");
	}
	
	private static void remove(Scanner scan, ArrayList<ExbStudent> stdList) {
		System.out.print("삭제 할 학생의 학년 반 번호를 입력해주세요 : ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		
		ExbStudent std = new ExbStudent(grade, classNum, num);
		if(equal(std, stdList)!=null) {
			stdList.remove(equal(std, stdList));
		}else {
			System.out.println("찾는 학생이 없습니다.");
		}		
	}

	private static void modify(Scanner scan, ArrayList<ExbStudent> stdList) {
		System.out.print("수정 할 학생의 학년 반 번호를 입력해주세요 : ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		
		ExbStudent std = new ExbStudent(grade, classNum, num);
		
		if(equal(std, stdList)!=null) {
			System.out.println("1학기 성적 : ");
			System.out.println("국어 : ");
			int kor1 = scan.nextInt();
			System.out.println("영어 : ");
			int eng1 = scan.nextInt();
			System.out.println("수학 : ");
			int math1 = scan.nextInt();
			
			System.out.println("2학기 성적 : ");
			System.out.println("국어 : ");
			int kor2 = scan.nextInt();
			System.out.println("영어 : ");
			int eng2 = scan.nextInt();
			System.out.println("수학 : ");
			int math2 = scan.nextInt();
			
			ExbScore k1Score = new ExbScore("국어", grade, 1, kor1);
			ExbScore e1Score = new ExbScore("영어", grade, 1, eng1);
			ExbScore m1Score = new ExbScore("수학", grade, 1, math1);
			ExbScore k2Score = new ExbScore("국어", grade, 2, kor2);
			ExbScore e2Score = new ExbScore("영어", grade, 2, eng2);
			ExbScore m2Score = new ExbScore("수학", grade, 2, math2);
			
			ArrayList<ExbScore> score = new ArrayList<ExbScore>();
			score.add(k1Score);
			score.add(e1Score);
			score.add(m1Score);
			score.add(k2Score);
			score.add(e2Score);
			score.add(m2Score);
			
			equal(std, stdList).setScore(score);
		}else {
			System.out.println("찾는 학생이 없습니다.");
		}		
	}

	public static void add(Scanner scan,ArrayList<ExbStudent> stdList) {
		int grade, classNum, num;
		String name;
		
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		scan.nextLine();
		ExbStudent std = new ExbStudent(grade, classNum, num);
		if(equal(std, stdList)==null) {
			System.out.print("이름 : ");
			name = scan.nextLine();
			std.setName(name);
			stdList.add(std);
			std.setScore(inputScore(scan, std));			
		} else {
			System.out.println("이미 있는 학생입니다.");
		}		
	}
	
	public static void printInfo(Scanner scan, ArrayList<ExbStudent> stdList) {
		System.out.print("출력 할 학생의 학년 반 번호를 입력해 주세요 : ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		
		ExbStudent std = new ExbStudent(grade, classNum, num);
		if(equal(std, stdList)!=null) {
			std = equal(std, stdList);
			String name = std.getName();
			System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name + " : ");	
			ArrayList<ExbScore> score = std.getScore();
			int kor1 = score.get(0).getPoint();
			int eng1 = score.get(1).getPoint();
			int math1 = score.get(2).getPoint();
			int kor2 = score.get(3).getPoint();
			int eng2 = score.get(4).getPoint();
			int math2 = score.get(5).getPoint();
			System.out.println("1학기 성적 : ");
			System.out.println("국어 : " + kor1 + ", 영어 : " + eng1 + ", 수학 : " + math1);

			System.out.println("2학기 성적 : ");
			System.out.println("국어 : " + kor2 + ", 영어 : " + eng2 + ", 수학 : " + math2);
			
		}else {
			System.out.println("찾는 학생이 없습니다.");
		}		
	}
	
	public static ExbStudent equal(ExbStudent std, ArrayList<ExbStudent> stdList) {
		int equalIndex = stdList.indexOf(std);
		if(equalIndex>=0) {
			return stdList.get(equalIndex);
		}else {
			return null;
		}
	}
	
	public static ArrayList<ExbScore> inputScore(Scanner scan, ExbStudent std) {
		System.out.println("1학기 : ");
		System.out.print("국어 : ");
		int kor1 = scan.nextInt();
		System.out.print("영어 : ");
		int eng1 = scan.nextInt();
		System.out.print("수학 : ");
		int math1 = scan.nextInt();
		int grade = std.getGrade();
		ExbScore k1Score = new ExbScore("국어", grade, 1, kor1);
		ExbScore e1Score = new ExbScore("영어", grade, 1, eng1);
		ExbScore m1Score = new ExbScore("수학", grade, 1, math1);
		
		System.out.println("2학기 : ");
		System.out.print("국어 : ");
		int kor2 = scan.nextInt();
		System.out.println("영어 : ");
		int eng2 = scan.nextInt();
		System.out.println("수학 : ");
		int math2 = scan.nextInt();
		
		ExbScore k2Score = new ExbScore("국어", grade, 2, kor2);
		ExbScore e2Score = new ExbScore("영어", grade, 2, eng2);
		ExbScore m2Score = new ExbScore("수학", grade, 2, math2);
		
		
		
		ArrayList<ExbScore> score = new ArrayList<ExbScore>();
		score.add(k1Score);
		score.add(e1Score);
		score.add(m1Score);
		score.add(k2Score);
		score.add(e2Score);
		score.add(m2Score);
		
		
		return score;
	}
}

package day16;

import java.util.*;


public class ExbListEx2 {

	public static void main(String[] args) {
		/* 그린 고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요 */
		
		ArrayList<ExbStudent> studentList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);
		
		stdManager(scan, studentList);
		
		scan.close();
	}
	/* 기능 : Scanner를 이용하여 학생 정보와 성적을 입력 받아 입력받은 학생 정보를 주어진 리스트에
	 * 		  넣어주는 메소드
	 * 매개변수 : Scanner, 주어진 리스트 => Scanner scan, ArrayList<ExbStudent> stdList
	 * 리턴타입 : 없음 => void
	 * 메소드명 : inputStudent
	 */
	public static void ipStd(Scanner scan, ArrayList<ExbStudent> studentList) {
		/* 학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료 */
		studentList.add(notice(scan));
	}
	/* 기능 : 학생 리스트가 주어지면 주어진 학생 정보들을 출력하는 메소드
	 * 매개변수 : 학생 리스트 => ArrayList<ExbStudent> studentList
	 * 리턴타입 : 없음 => void
	 * 메소드명 : pribtStudentList
	 */
	public static void print(ArrayList<ExbStudent> studentList) {
		Iterator<ExbStudent> it = studentList.iterator(); 
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);
		}
	}
	/* 기능 : Scanner를 이용하여 학생 정보와 성적을 입력 받아 입력받은 학생 정보를 알려주는 메소드
	 * 매개변수 : Scanner => Scanner scan
	 * 리턴타입 : 입력받은 학생 정보 => ExbStudent
	 * 메소드명 : inputStudent
	 */
	public static ExbStudent notice(Scanner scan) {
		/* 학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료 */
	
		System.out.println("학생 정보를 입력하세요. : ");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		/* nextLine()을 이용하는 경우 앞에서 Scanner를 통해 입력받은 값 중 엔터가 
		 * 사라지지 않은 상황이면 실제 사용하려는 nextLine()앞에 nextLine()을
		 * 한 번 더 입력해야 한다.
		 */
		scan.nextLine();
		String name = scan.nextLine();
		System.out.println("성적을 입력하세요. : ");
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		ExbStudent std
			= new ExbStudent(kor, eng, math, grade, classNum, num, name);
		return std;
	
	}
	
	public static void printmenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 학생정보 추가");
		System.out.println("2. 전체 학생정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("원하는 메뉴를 입력하세요 : ");
	}

	public static void stdManager(Scanner scan, ArrayList<ExbStudent> studentList) {
		int menu;
		do {
			printmenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				ipStd(scan,studentList);
				break;
			case 2:
				print(studentList);
				break;
			case 3:
				break;
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
			System.out.println("프로그램 종료");
		}while(menu!=3);
	}
	
}
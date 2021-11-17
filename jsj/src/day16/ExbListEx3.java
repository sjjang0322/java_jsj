package day16;

import java.util.*;


public class ExbListEx3 {

	public static void main(String[] args) {
		/* 그린 고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요 */
		
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);
		
		stdManager(scan, stdList);
		
		scan.close();
	}
	/* 기능 : Scanner를 이용하여 학생 정보와 성적을 입력 받아 입력받은 학생 정보를 주어진 리스트에
	 * 		  넣어주는 메소드
	 * 매개변수 : Scanner, 주어진 리스트 => Scanner scan, ArrayList<ExbStudent> stdList
	 * 리턴타입 : 없음 => void
	 * 메소드명 : inputStudent
	 */
	public static void ipStd(Scanner scan, ArrayList<ExbStudent> stdList) {
		/* 학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료 */
		stdList.add(notice(scan));
	}
	/* 기능 : 학생 리스트가 주어지면 주어진 학생 정보들을 출력하는 메소드
	 * 매개변수 : 학생 리스트 => ArrayList<ExbStudent> studentList
	 * 리턴타입 : 없음 => void
	 * 메소드명 : pribtStudentList
	 */
	public static void print(ArrayList<ExbStudent> stdList) {
		Iterator<ExbStudent> it = stdList.iterator(); 
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
		System.out.println("3. 학생 정보 삭제(삭제할 학생의 정보를 입력하여 일치하는 학생의 정보를 삭제)");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 프로그램 종료");
		System.out.print("원하는 메뉴를 입력하세요 : ");
	}

	public static void stdManager(Scanner scan, ArrayList<ExbStudent> stdList) {
		int menu;
		do {
			printmenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				ipStd(scan,stdList);
				break;
			case 2:
				print(stdList);
				break;
			case 3:
				//deleteStd(scan, studentList);
				if(deleteStudent(stdList, scan)) {
					System.out.println("학생 정보를 삭제했습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			case 4:
				System.out.println("프로그램 종료");

				break;
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu!=4);
	}
	/* 기능 : 주어진 리스트에 Scanner를 통해 입력받은 학생 정보를 삭제하여 삭제됬는지 알려주는 메소드
	 * 매개변수 : 주어진 리스트, Scanner => ArrayList<ExbStudent> stdList, Scanner scan
	 * 리턴타빙 : 삭제됬는지 안됬는지 => boolean
	 * 메소드명 : deleteStudent
	 */
	public static boolean deleteStudent(ArrayList<ExbStudent> stdList, Scanner scan) {
		System.out.println("학생 정보를 입력하세요. : ");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		/* 방법 1
		 * 삭제할 학생 정보가 몇번지에 있는지 확인하는 작업을 위해
		 * ExbStudent클래스의 equals를 오버라이딩 해야함
		 * 리스트에 특정 개체가 있는지 확인할 때 사용하는 메소드 : contains, indexOf 
		 * 있으면 해당번지에 있는 학생 정보를 삭제
		 */
		ExbStudent std = new ExbStudent(0, 0, 0, grade, classNum, num, null);
		/*
		int index = studentList.indexOf(std);
		if(index>=0) {
			studentList.remove(index);
			//System.out.println("학생정보를 삭제했습니다.");
			return true;
		}else {
			//System.out.println("일치하는 학생 정보가 없습니다.");
			return false;
		}
		*/
		/* 방법 2
		 * 학생 정보를 삭제했을때 해당 학생 정보가 있으면 삭제되었습니다.
		 * 없으면 삭제할 학생 정보가 없습니다를 출력
		 */
		return stdList.remove(std);
	}
	
	public static void deleteStd(Scanner scan, ArrayList<ExbStudent> stdList) {
		ExbStudent std = notice(scan);
		for(int i=0;i<stdList.size();i++) {
			if(stdList.get(i).equals(std)) {
				stdList.remove(i);
			}
		}
	}
}
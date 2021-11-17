package day16;

import java.util.*;


public class ExbListEx1 {

	public static void main(String[] args) {
		/* 그린 고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요 */
		/* 국어, 영어, 수학 성적을 각각 리스트로 만들어서 관리하는 방법
		 * 번지가 같으면 같은 학생의 성적이라는 가정이 필요	 
		 * 가능은 하지만 좋은 방법은 아님 */
		/*
		ArrayList<Integer> kor = new ArrayList<Integer>();
		ArrayList<Integer> eng = new ArrayList<Integer>();
		ArrayList<Integer> math = new ArrayList<Integer>();
		*/
		/* 국어, 영어, 수학 성적을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법
		 */
		ArrayList<ExbStudent> studentList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);
		
		/* 학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료 */
		/* 학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 계속하고 아니면 종료 */
		char next = 'y';
		while(next == 'y' || next == 'Y') {
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
			System.out.print("학생 정보를 더 입력하겠습니까? ");
			next = scan.next().charAt(0);
			ExbStudent std
				= new ExbStudent(kor, eng, math, grade, classNum, num, name);
			studentList.add(std);
		}
		ipStd(scan,studentList);
		char next1 = 'y';
		while(next1 == 'y' || next1 == 'Y') {
			studentList.add(notice(scan));
			System.out.print("학생 정보를 더 입력하겠습니까? ");
			next1 = scan.next().charAt(0);
		}
		/* 입력받은 학생 정보를 출력 : iterator를 이용*/
		Iterator<ExbStudent> it = studentList.iterator(); 
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);

		}
		print(studentList);
		
		
		//위의 코드를 이용하여 학생정보를 입력하는 메소드와 학생 정보들을 출력하는 메소드를 만들어 보세요
		
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
		char next = 'y';
		while(next == 'y' || next == 'Y') {
			studentList.add(notice(scan));

			System.out.print("학생 정보를 더 입력하겠습니까? ");
			next = scan.next().charAt(0);
			
		}
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


	
}
class ExbStudent2{
	//private으로 설정 : 외부에서 멤버변수에 직접 접근하지 못하게 하기 위해서
	private int kor,eng,math,grade,classNum,num;
	private String name;
	//생성자를 추가 : 멤버 변수를 쉽게 초기화 하기 위해서 
	public ExbStudent2(int kor, int eng, int math, int grade, int classNum, int num, String name) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	public ExbStudent2() {}
	//toString을 추가 : 멤버변수를 문자열로 쉽게 확인하기 위해서
	@Override
	public String toString() {
		return name + "\n [국어=" + kor + ", 영어=" + eng + ", 수학=" + math + ", 학년=" + grade + ", 반="
				+ classNum + ", 번호=" + num + "]\n";
	}
	
	//getter와 setter 추가 : 외부에서 멤버변수의 값을 확인하거나 수정하기 위해서
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void add(int kor, int eng, int math, int grade, int classNum, int num, String name) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbStudent other = (ExbStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
}
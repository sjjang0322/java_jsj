package day9;

public class ClassEx4 {

	public static void main(String[] args) {
		/* 학생 1명의 정보를 관리하는 예제 : 클래스 사용 X */
		String sName = "그린고등학교", name = "홍길동";
		int grade = 1, classNum = 1, num = 1;
		
		System.out.println("학교명 : " + sName);
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		
		String sName1 = "그린고등학교", name1 = "임꺽정";
		int grade1 = 1, classNum1 = 1, num1 = 2;
		
		System.out.println("학교명 : " + sName1);
		System.out.println("이름 : " + name1);
		System.out.println("학년 : " + grade1);
		System.out.println("반 : " + classNum1);
		System.out.println("번호 : " + num1);
		
		
		
		/* 학생 1명의 정보를 관리하는 예제 : 클래스 사용 HighSchoolStudent */
		HighSchoolStudent2 std = new HighSchoolStudent2("그린고등학교","홍길동",1,1,1);
		std.printInfo();
		HighSchoolStudent2 std1 = new HighSchoolStudent2("그린고등학교","임꺽정",1,1,2);
		std1.printInfo();
	}
	
	

}

class HighSchoolStudent2{
	String schoolName, name;
	int grade, classNum, num;
	
	public HighSchoolStudent2(){
		schoolName = "고등학교";
		name = "";
		grade = 1; classNum = 1; num = 1;
	}
	
	HighSchoolStudent2(String schoolName, String name, int grade, int classNum, int num) {
		
		this.schoolName = schoolName;
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	
	public void printInfo() {
		System.out.println("학교명 : " + schoolName);
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
	}
}
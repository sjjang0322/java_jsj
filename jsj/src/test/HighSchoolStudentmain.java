package test;

public class HighSchoolStudentmain {

	public static void main(String[] args) {
		HighSchoolStudent std1 = new HighSchoolStudent("그린고등학교","장성제",1,1,1);
		
		std1.print();		
		
	}
	
	
}

class HighSchoolStudent {
	private String school, name;
	private int grade, classNum, num;
		
	public HighSchoolStudent(String school, String name, int grade, int classNum, int num) {
		this.school = school;
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	public void print() {
		System.out.println(school + " " + grade + "학년 " + classNum + "반 " + num + "번 " + name);
	}
	
}

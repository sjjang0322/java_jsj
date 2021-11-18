package day16;

public class ExbStudent {
	//private으로 설정 : 외부에서 멤버변수에 직접 접근하지 못하게 하기 위해서
		private int kor,eng,math;
		int grade;
		int classNum;
		int num;
		private String name;
		//생성자를 추가 : 멤버 변수를 쉽게 초기화 하기 위해서 
		public ExbStudent(int kor, int eng, int math, int grade, int classNum, int num, String name) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.grade = grade;
			this.classNum = classNum;
			this.num = num;
			this.name = name;
		}
		
		public ExbStudent() {}
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

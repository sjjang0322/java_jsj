package day17;

public class ExbScore {
	private String sbjectTitle;
	private int grade;
	private int term;
	private int point;
	
	public ExbScore() {
	}

	public ExbScore(String sbjectTitle, int grade, int term, int point) {
		this.sbjectTitle = sbjectTitle;
		this.grade = grade;
		this.term = term;
		this.point = point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((sbjectTitle == null) ? 0 : sbjectTitle.hashCode());
		result = prime * result + term;
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
		ExbScore other = (ExbScore) obj;
		if (grade != other.grade)
			return false;
		if (sbjectTitle == null) {
			if (other.sbjectTitle != null)
				return false;
		} else if (!sbjectTitle.equals(other.sbjectTitle))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

	public String getSbjectTitle() {
		return sbjectTitle;
	}

	public void setSbjectTitle(String sbjectTitle) {
		this.sbjectTitle = sbjectTitle;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
}

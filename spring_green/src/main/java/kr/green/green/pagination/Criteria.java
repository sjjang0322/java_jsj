package kr.green.green.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page;
	private int perPageNum;
	private String type;
	private String search; 

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;		
		this.type = "일반";
		this.search = "";
	}	

	public Criteria(Integer page, int perPageNum, String bd_type) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.type = bd_type;
		this.search = "";
	}

	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}

	public String getTypeTitle() {
		if(type.equals("일반"))
			return "게시글";
		if(type.equals("공지"))
			return "공지사항";
		if(type.equals("qna"))
			return "QnA";
		return "";
	}
	
}

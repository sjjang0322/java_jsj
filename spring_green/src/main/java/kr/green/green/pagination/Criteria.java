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
		this.search = "";
	}	

	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}

	public String getTitle() {
		if(type=="일반")
			return "게시글";
		if(type=="공지")
			return "공지사항";
		if(type=="qna")
			return "QnA";
		return "";
	}
	
}

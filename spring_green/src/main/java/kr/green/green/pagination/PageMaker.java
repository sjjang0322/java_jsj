package kr.green.green.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria criteria;		
	
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = cri;		
		calcData();
	}
	
	public void calcData() {
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);		
		startPage = (endPage - displayPageNum)+1;		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}		
		
//		prev = criteria.getPage() == 1 ? false : true;		
//		next = criteria.getPage() == tempEndPage ? false:true;
		prev = startPage == 1 ? false : true;		
		next = endPage == tempEndPage ? false:true;
	}
	
}

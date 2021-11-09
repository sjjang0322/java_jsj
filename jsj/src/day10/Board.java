package day10;

public class Board {
	//게시글 번호, 제목, 작성자, 조회수, 내용, 작성일 등
	private int num, views, like, dislike;
	private String title, contents, date, writer;
	
	public Board() {}
	public Board(int num,String title,String contents,String date,String writer) {
		this.num = num;
		this.views = 0;
		this.like = 0;
		this.dislike = 0;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
	}
	public void print() {
		System.out.println("글번호 : " + num);
		System.out.println("제목 : " + title);	
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views);
		System.out.println("추천 : " + like);
		System.out.println("비추천 : " + dislike);
		System.out.println("작성시간 : " + date);
		System.out.println("내용 : " + contents);
	}
	public void printInfo() {
		System.out.println("글번호 : " + num);
		System.out.println("제목 : " + title);	
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views);
		System.out.println("추천 : " + like);
		System.out.println("비추천 : " + dislike);
		System.out.println("작성시간 : " + date);
		System.out.println("내용 : " + contents);
	}
	
	public void view() {
		views++;
	}
	
	public void like() {
		like++;
	}
	
	public void dislike() {
		dislike++;
	}
	// 일반적으로 멤버변수를 변경만 하는 기능들은 리턴타입이 void
	//게시글 제목, 내용을 수정하는 기능
	public void modify(String title,String contents) {
		this.title = title; this.contents = contents;
	}
	
	
	public void retitle(String title) {
		this.title = title;
	}
	
	public void recontents(String contents) {
		this.contents = contents;
	}
}

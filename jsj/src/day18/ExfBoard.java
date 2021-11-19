package day18;

import java.util.Date;

public class ExfBoard {
	//게시글 번호, 제목, 작성자, 조회수, 내용, 작성일 등
	//클래스 변수를 이용하여 게시글 번호를 관리
		private int num, views;
		private String title, contents, date, writer;
		Date date1 = new Date();
		public ExfBoard() {
		}
		public ExfBoard(int num, String title, String contents, String writer) {
			this.num = num;
			this.views = 0;
			this.title = title;
			this.contents = contents;
			this.date = date1.toString();
			this.writer = writer;
		}
		public ExfBoard(int num) {
			this.num = num;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getViews() {
			return views;
		}
		public void setViews(int views) {
			this.views = views;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		@Override
		public String toString() {
			return "ExfBoard [num=" + num + ", views=" + views + ", title=" + title + ", contents=" + contents
					+ ", date=" + date + ", writer=" + writer + ", date1=" + date1 + "]";
		}
		public void print() {
			System.out.println("글번호 : " + (num+1));
			System.out.println("조회수 : " + views);
			System.out.println("글제목 : " + title);
			System.out.println("글내용 : " + contents);
			System.out.println("작성일 : " + date);
			System.out.println("작성자 : " + writer);
		}
		public void retitle(String title) {
			this.title = title;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ExfBoard other = (ExfBoard) obj;
			if (num != other.num)
				return false;
			return true;
		}

		public void recontents(String contents) {
			this.contents = contents;
		}
		public void view() {
			views++;
		}
}

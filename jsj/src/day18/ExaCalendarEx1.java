package day18;

import java.util.*;

public class ExaCalendarEx1 {
	public static void main(String[] args) {
		/* 현재 시간을 기준으로 객체를 만들어서 넘겨줌
		 * Calendar는 요일, 년, 월, 일 정보들을 쉽게 확인 할 때 사용
		 */
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		/* Calendar의 get 메소드를 이용하여 년, 월, 일, 요일 등의 정보를 가져올 수 있다
		 * 월은 0부터 시작, 0~11
		 * 요일은 일요일부터 시작, 일요일이 1
		 * HOUR은 1~12, HOUR_OF_DAY은 1~24
		 * */
		cal.set(Calendar.HOUR_OF_DAY, 14);
		System.out.println("년 : " + cal.get(Calendar.YEAR));			//년도
		System.out.println("월 : " + (cal.get(Calendar.MONTH)+1));		//월
		System.out.println("일 : " + cal.get(Calendar.DATE));			//일
		System.out.println("요일 : " + cal.get(Calendar.DAY_OF_WEEK));	//요일
		System.out.println("시 : " + cal.get(Calendar.HOUR));			//시
		System.out.println("시 : " + cal.get(Calendar.HOUR_OF_DAY));	//시
		System.out.println("분 : " + cal.get(Calendar.MINUTE));			//분
		System.out.println("초 : " + cal.get(Calendar.SECOND));			//초
		
		Calendar cal2 = Calendar.getInstance();
		System.out.println("시 : " + cal2.get(Calendar.HOUR_OF_DAY));	//시
		System.out.println("시 : " + cal.get(Calendar.HOUR_OF_DAY));	//시
	}
}

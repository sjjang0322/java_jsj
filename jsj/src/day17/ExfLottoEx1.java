package day17;

import java.util.*;

public class ExfLottoEx1 {

	public static void main(String[] args) {
		/* 로또 프로그램을 day17 패키지의 야구게임을 활용하여 만드세요. */
		Scanner scan = new Scanner(System.in);
		List<Integer> lotto = new ArrayList<Integer>();
		List<List<Integer>> userList = new ArrayList<List<Integer>>();
		int min = 1, max = 45, count = 7, num;
		
		//당첨번호 생성
		ExeBaseBallEx1.createRandomList(lotto, min, max, count);
		//System.out.println(lotto);
		//몇장 살지 입력
		System.out.print("몇장을 사시겠습니까? : ");
		num = scan.nextInt();
		
		
		for(int i=0;i<num;i++) {
			List<Integer> user = new ArrayList<Integer>();

			//번호 입력
			inputNum(scan, user, count, i);
			userList.add(user);
			//System.out.println(user);
		}
		//System.out.println(userList);
		//결과 출력
		for(int i=0;i<num;i++) {
			result(userList.get(i), lotto, count);
		}
	}
	
	public static boolean inputUser(Scanner scan,List<Integer> user, int count, int i1) {
		Set<Integer> userSet = new HashSet<Integer>();
		user.clear();
		System.out.print((i1+1) + "번째 숫자 " + (count - 1) + "개를 입력하세요 : ");
				
		for(int i=0;i<6;i++) {
			int num = scan.nextInt();
			userSet.add(num);
			user.add(num);
		}
		if(userSet.size() != user.size()) {
			System.out.println("중복된 숫자를 입력했습니다!!!!!!");
			return false;
		}
		return true;
	}
	
	public static void inputNum(Scanner scan, List<Integer> user, int count, int i1) {
		for(;;) {
			if(inputUser(scan, user, count, i1)) {
				break;
			}
		}
	}
	
	public static int correct(List<Integer> user, List<Integer> lotto) {
		int correct=0;
		for(int i=0;i<user.size();i++) {
			if(user.contains(lotto.get(i))) {
				correct++;
			}
		}
		return correct;
	}
	
	public static boolean bonus(List<Integer> user, List<Integer> lotto, int count) {
		return user.contains(lotto.get(count-1));
	}
	
	public static void result(List<Integer> user, List<Integer> lotto, int count) {
		switch(correct(user, lotto)) {
		case 3 : System.out.println("5등입니다."); break;
		case 4 : System.out.println("4등입니다."); break;
		case 5 : if(bonus(user, lotto, count)) {
			System.out.println("2등입니다."); break;
		}else {
			System.out.println("3등입니다."); break;
		}
		case 6 : System.out.println("1등입니다."); break;
		default : System.out.println("꽝입니다.");
		}
	}
}

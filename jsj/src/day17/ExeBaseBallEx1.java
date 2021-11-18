package day17;

import java.util.*;

public class ExeBaseBallEx1 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자 야구 게임을 구현해보세요.
		 * 
		 */
		//정답 리스트
		//생성된 숫자를 저장할 리스트 선언 및 생성
		List<Integer> com = new ArrayList<Integer>();
		int min=1, max=9, count=3;

		//정답 생성
		try {
			createRandomList(com, min, max, count);
		}catch(Exception e){
			System.out.println("=============================");
			System.out.println("예외 발생!! : " + e.getMessage());
			System.out.println("=============================");
			System.out.println("숫자 생성에 실패하여 게임을 할 수 없습니다.");
			return;
		}
		//문제 풀이
		solve(com);		
	}
	//정답 생성
	public static void createRandomList(List<Integer> com,int min,int max,int count) throws NullPointerException,RuntimeException{
		if(com == null) {
			//리스트 비어서 일 안함
			//return;	
			
			//리스트가 비어서 문제 발생함
			throw new NullPointerException("리스트가 null입니다.");
		}
		
		//중복되지 않은 숫자를 생성하기 위한 임시 set을 선언 및 생성
		Set<Integer> comSet = new HashSet<Integer>();
		
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max-min+1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다.");
		}
		//comSet에 3개 저장될때까지 반복
		while(comSet.size()<count) {
			//랜덤한 수 생성
			int r = (int)(Math.random()*(max-min+1) + min);
			//comSet 생성한 랜덤수를 저장
			boolean isAdd = comSet.add(r);
			//위에서 랜덤수가 저장이 됐다면 com리스트에 랜덤수를 저장
			if(isAdd) {
				com.add(r);
			}
			/* if(comSet.arr(r)){
			 * 		com.add(r);
			 * }
			 */
		}
	}
	//답안 입력
	public static boolean inputUser(Scanner scan,List<Integer> user) {
		Set<Integer> userSet = new HashSet<Integer>();
		
		System.out.print("숫자 3개를 입력하세요(예 123) : ");
		
		int num = scan.nextInt();
		
		for(int i=0;i<3;i++) {
			userSet.add(num/(int)(Math.pow(10, 2-i)));
			user.add(num/(int)(Math.pow(10, 2-i)));
			num %= (int)(Math.pow(10, 2-i));
			if(userSet.size() != user.size()) {
				System.out.println("중복된 숫자를 입력했습니다!!!!!!");
				return false;
			}
		}
		return true;
	}
	//스트라이크 갯수 세기
	/* 기능 : 두 정수 리스트가 주어지면 같은 번지에 있는 숫자가 몇개 같은지 알려주는 메소드
	 * 매개변수 : 두 정수 리스트 => List<Integer> list1, List<Integer> list2
	 * 리턴타입 : 같은 번지에 있는 숫자 중 같은 숫자의 갯수 => 정수 => int
	 * 메소드명 : getStrike
	 */
	public static int countStrike(List<Integer> com, List<Integer> user) {
		int strike = 0;
		for(int i=0;i<user.size();i++) {
			if(user.get(i).equals(com.get(i))) {
				strike++;
			}				
		}
		return strike;
	}
	//볼 갯수 세기
	/* 기능 : 두 정수 리스트가 주어지면 다른 번지에 있는 숫자가 몇개 같은지 알려주는 메소드
	 * 매개변수 : 두 정수 리스트 => List<Integer> list1, List<Integer> list2
	 * 리턴타입 : 같은 번지에 있는 숫자 중 같은 숫자의 갯수 => 정수 => int
	 * 메소드명 : getBall
	 */
	public static int countBall(List<Integer> com, List<Integer> user) {
		int ball = 0;
		for(int i=0;i<user.size();i++) {
			if(!(user.get(i).equals(com.get(i))) && com.contains(user.get(i))) {
				ball++;
			}				
		}
		return ball;
	}
	//게임 결과 출력
	public static void result(int strike,int ball) {
		if(strike==3) {
			System.out.println("3S 정답입니다.");
		}else if(strike!=0) {
			System.out.print(strike + "S");
		}
		if(ball!=0) {
			System.out.print(ball + "B");
		}
		if(strike==0&&ball==0) {
			System.out.print("3O");
		}
		System.out.println();
	}
	//게임 실행
	public static void solve(List<Integer> com) {
		Scanner scan = new Scanner(System.in);	
		//반복 : 다 맞출때까지 반복 => 3스트라이크가 될때까지
		for(;;) {
			List<Integer> user = new ArrayList<Integer>();
			if(!inputUser(scan, user)) {
				continue;
			}
					
			int strike = countStrike(com, user);
			int ball = countBall(com, user);
			
			result(strike, ball);
			if(strike==3) {
				break;
			}
		}	
		scan.close();
	}
	/* 기능 : 정수 리스트가 주어지면 해당 정수 리스트에 min~max 사이의 값을 스캐너를 통해
	 * 		 count개 입력받아 제대로 입력했는지를 알려주는 메소드
	 *	 	 0 : 제대로 입력, 1 : 범위 잘못, -1 : 중복
	 * 매개변수 : 리스트, 범위, 갯수, 스캐너 =>
	 * 			List<Integer> list, int min, int max, int count, Scanner scan
	 * 리턴타입 : 0, 1, -1 => 정수 => int
	 * 메소드명 : inputList 
	 */
	public static int inputList(List<Integer> list, int min, int max, int count, Scanner scan) {
		if(list == null) {
			throw new NullPointerException("리스트가 null입니다.");
		}
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min +1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다."); 
		}
		if(scan == null) {
			throw new NullPointerException("Scanner가 null입니다.");	
		}
		int i=0;
		Set<Integer> useSet = new HashSet<Integer>();
		boolean	isOutOfBounds = false;
		while(i < count) {
			int tmp = scan.nextInt();
			useSet.add(tmp);
			list.add(tmp);
			//isOutOfBounds = tmp >= min && tmp <= max ? false : true;
			if(tmp < min || tmp > max) {
				isOutOfBounds = true;
			}
			i++;
		}
		if(useSet.size() != count) {
			return -1;
		}
		//return isOutOfBounds ? 1 : 0;
		if(isOutOfBounds) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

package day8;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx1 {

	public static void main(String[] args) {
		/* 1~45사이의 중복되지 않은 6개의 로또 번호와 1개의 보너스 번호를 생성
		 * 
		 */
		
		int[] lotto;
		int[] user;
		int bonus;
		int min=1,max=45,size=6;
		//로또번호 6자리 생성
		lotto = randNum(min,max,size);
		//보너스 번호 생성
		bonus = createBonus(min,max,lotto);
		
		//당첨번호 출력
		System.out.println("당첨번호 : " + Arrays.toString(lotto) + " 보너스 : " + bonus);
		//사용자가 1~45사이의 숫자 6개를 중복되지 않게 콘솔에서 입력(메소드X)
		for(;;) {
			System.out.print("번호입력 : ");
			Scanner scan = new Scanner(System.in);
			user = new int[size];
			int countO=0;
			for(int i=0;i<user.length;i++) {
				user[i] = scan.nextInt();
				if(user[i]<min||user[i]>max) {
					countO++;
				}
			}
			int countC = 0;			
			for(int i=1;i<user.length;i++) {
				if(isBe2(user,user[i],i)) {
					countC++;
				}
			}
			if(countC==0&&countO==0) {
				break;
			} else if(countO==0 ){
				System.out.println("숫자가 중복되었습니다.");
			} else {
				System.out.println("1~45 사이의 숫자만 입력하십시오.");
			}
		}
		//등수를 출력
		/* 1등 : 당첨번호 6개 전부 일치
		 * 2등 : 당첨번호 5개와 보너스 번호 일치
		 * 3등 : 당첨번호 5개 일치
		 * 4등 : 당첨번호 4개 일치
		 * 5등 : 당첨번호 3개 일치
		 * 꽝  : 나머지
		 */
		//맞은 수 갯수 구하기
		int cntCorr = 0;
		for(int i=0;i<user.length;i++) {
			if(isBe(lotto, user[i])) {
				cntCorr++;
			}
		}
		//등수 확인
		switch(cntCorr) {
		case 6 : System.out.println("1등 당첨입니다.");
		break;
		case 5 : if(isBe(user,bonus)) {
			System.out.println("2등 당첨입니다.");
			break;
		} else {
			System.out.println("3등 당첨입니다.");
			break;
		}
		case 4 : System.out.println("4등 당첨입니다.");
		break;
		case 3 : System.out.println("5등 당첨입니다.");
		break;
		default : System.out.println("꽝입니다.");
		}
		
	}

	public static boolean isBe(int[] arr, int a) {
		for(int i=0;i<arr.length;i++){
			if(arr[i]==a) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean isBe2(int[] arr, int a, int n) {
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
		//아니면 원래 검사 개수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i=0;i<n;i++){
			if(arr[i]==a) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] randNum(int min,int max,int size) {
		int[] arr = new int[size];
		for(int count=0; count < size ;	) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!isBe2(arr,random,count)) {
				arr[count++] = random;
			}
		}
		return arr;
	}
	
	/* 기능 : 최소값(min), 최대값(max),배열이 주어지면 min~max사이의 랜덤한 수를 생성하여
	 *       배열에 있는지 없는지 확인후 없으면 해당 수를 알려주는 메소드
	 * 매개변수 : 최소값, 최대값, 배열=>int min, int max, int[] arr
	 * 리턴타입 : 배열에 없는 min~max사이의 랜덤한 수 => 정수 => int
	 * 메소드명 : createBonus     	
	 */
	public static int createBonus(int min, int max, int[] arr) {
		//보너스번호 생성
		int bonus = 0;
		for(;;) {
			int a = (int)(Math.random()*(max-min+1))+min;
			if(!isBe(arr,a)) {
				bonus = a;
				break;
			}
		}
		return bonus;
	}
	/* 기능 : 두 배열이 주어지면, 두 배열에서 일치하는 정수의 갯수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int []arr1, int []arr2
	 * 리턴타입 : 일치하는 정수의 갯수 => 정수 => int
	 * 메소드명 : check
	 */
	public static int check(int[] arr1,int []arr2) {
		int count = 0;
		for(int tmp : arr1) {
			//배열 arr2에 배열 arr1에서 꺼낸 tmp가 있으면 count를 1증가
			if(isBe2(arr2,tmp,arr2.length)) {
				count++;
			}
		}
		return count;
	}
	
	/* 기능 : 로또 번호와 사용자 번호를 이용하여 당첨등수를 출력하는 메소드
	 * 매개변수 : 로또번호와 보너스 번호, 사용자번호
	 *  		=>int []lotto, int bonus, int []user
	 * 리턴타입 : 없음 => void
	 * 메소드명 : rank
	 */
	
	public static void rank(int []lotto, int bonus, int []user) {
		int count = check(lotto, user);
		String result = "";
		switch(count) {
		case 6 : result = "1등 당첨입니다.";
		break;
		case 5 : result = isBe(user,bonus) ? "2등 당첨입니다." : "3등 당첨입니다.";
		break;		
		case 4 : result = "4등 당첨입니다.";
		break;
		case 3 : result = "5등 당첨입니다.";
		break;
		default : result = "꽝입니다.";
		}
		System.out.println(result);
	}
	
}

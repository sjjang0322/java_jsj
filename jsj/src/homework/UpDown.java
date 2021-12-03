package homework;

import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int correctNum,num;
		num=0;
		correctNum = (int) (Math.random()*100);
		while(num!=correctNum) {
			System.out.print("정수 : ");
			num=scan.nextInt();
			switch(upDown(num,correctNum)) {
				case 'c':System.out.println("정답입니다."); break;
				case 'd':System.out.println("down"); break;
				case 'u':System.out.println("up"); break;
			}
		}
		System.out.println("종료");
		scan.close();
	}
	
	static char upDown(int num,int correctNum) {
		if(num==correctNum) {
			return 'c';
		} else if(num>correctNum){
			return 'd';
		} else if(num<correctNum) {
			return 'u';
		}
		return 'n';
	}
	
}

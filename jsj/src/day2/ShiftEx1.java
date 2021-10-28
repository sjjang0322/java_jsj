package day2;

public class ShiftEx1 {

	public static void main(String[] args) {
		// 12      : 00000000 00000000 00000000 00001100
		// 12 << 2 : 00000000 00000000 00000000 00110000  : 48
		// 12 >> 2 : 00000000 00000000 00000000 00000011  : 3
		int num1 =12;
		int leftShift = num1 << 2;
		int rightShift = num1 >> 2;
		
		System.out.println(num1 + " << 2 = " + leftShift);
		System.out.println(num1 + " >> 2 = " + rightShift);
	}

}

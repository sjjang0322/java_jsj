package day6;

public class ArrayMultiDimensionEx2 {

	public static void main(String[] args) {
		/* 구구단 2단에서 9단 전체를 배열에 저장하여 출력하는 코드를 작성하세요.
		 */
		
		int multipleTable[][] = new int[10][10];
		
		for(int i=2;i<multipleTable.length;i++) {
			for(int j=1;j<multipleTable[i].length;j++) {
				multipleTable[i][j] = i*j;
				System.out.println(i + " X " + j + " = " + multipleTable[i][j]);
			}
		}
		
		
	}

}

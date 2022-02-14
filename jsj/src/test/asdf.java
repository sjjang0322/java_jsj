package test;

public class asdf {

	public static void main(String[] args) {
		String pw = "";
		for(int i=0;i<26;i++) {
			int tmp = (int) (Math.random()*61);
			if(tmp<10) {
				pw += (char)(tmp+48);
			} else if(tmp<36){
				pw += (char)(tmp+65);
			} else if(tmp<62){
				pw += (char)(tmp+97);
			}
		}
		System.out.println(pw);
	}

}

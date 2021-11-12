package day13;

public class ExdTestEx1 {

	public static void main(String[] args) {
		ExdLGTvRemoteCon lgR = new ExdLGTvRemoteCon(30, 900);
		
		lgR.volumeUp();
		lgR.powerOn();
		for(int i = 1; i<= 31; i++) {
			lgR.volumeUp();
		}
		for(int i = 1; i<32; i++) {
			lgR.volumeDown();
		}
		System.out.println(lgR.LOGO);
		lgR.changeChannel(901);
		lgR.powerOff();
	}

}

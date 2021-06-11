package quiz02;

public class Speaker {
	private int vol;//0~100
	public void volUp() {
		vol++;
		if(vol>100) vol=100;
		System.out.println("볼륨 : " + vol);
	}
	public void volDown() {
		vol--;
		if(vol<0)vol=0;
		System.out.println("볼륨 : " + vol);
	}
	public Speaker () {}
	public Speaker(int vol) {
		super();
		this.vol = vol;
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	
}

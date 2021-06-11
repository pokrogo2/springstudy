package quiz02;

import javax.inject.Inject;

public class TV {
	private int ch; //0~100
	@Inject
	private Speaker speaker;
	public void chUp() {
		ch++;
		if(ch>100)ch=100;
		System.out.println("채널 : " +ch);
	}
	public void chDown() {
		ch--;
		if(ch<0)ch=0;
		System.out.println("채널 : " +ch);
	}
	public void volUp() {
		speaker.volUp();
	}
	public void volDown() {
		speaker.volDown();
	}
	public TV() {}
	public TV(int ch, Speaker speaker) {
		super();
		this.ch = ch;
		this.speaker = speaker;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
}

package spring5;

//문자전송 시스템
public class SmsSender {
	boolean flag;//문자가 제대로 전달됐는지 체크
	
	//contructor-arg
	public SmsSender(boolean flag) {
		this.flag=flag;
	}
	
	//----------------------------------------
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SmsSender call";
	}
}

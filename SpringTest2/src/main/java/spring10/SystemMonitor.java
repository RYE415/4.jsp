package spring10;

public class SystemMonitor {
	//1)byType=>@AutoWired
	/*
	 * private PhoneCall call;//PhoneCall과 같은 자료형의 객체를 찾아와 멤버변수 call과 자동으로 저장

	public void setCall(PhoneCall call) {//<property name="call">
		this.call = call;
		System.out.println("setCall() call=>"+call);
	}
	*/
	//2)byName=>@Resource와 같은 개념=>Type으로 객체를 찾아서 넣어주는 것이 아니라 객체 이름으로 찾아서 자동으로 객체를 넣어주는 개념
	private PhoneCall phonecall;//type과 이름을 같게 설정
								//보통 디폴트로 멤버변수 이름을 객체명
	
	
	public void setPhonecall(PhoneCall phonecall) {
		this.phonecall = phonecall;
		System.out.println("setPhonecall() call(phonecall)=>"+phonecall);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[PhoneCall object]=>"+phonecall;
	}
	
	
}

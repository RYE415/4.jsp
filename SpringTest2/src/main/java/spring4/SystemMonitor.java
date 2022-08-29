package spring4;

//문자를 전송=>기간을 정하기
public class SystemMonitor {

	private long periodTime;//기간
	//has a
	private SmsSender sender;
	
	//생성자를 이용->C네임스페이스를 이용해서 설정이 가능
	public SystemMonitor(long periodTime, SmsSender sender) {
		this.periodTime = periodTime;
		this.sender = sender;
		System.out.println("SystemMonitor() Constructor call");
	}

	//-----------------------------------------------------
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SystemMonitor[periodTime="+periodTime+",sender="+sender+"]";
	}
}

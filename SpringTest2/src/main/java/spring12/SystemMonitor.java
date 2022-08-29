package spring12;

import javax.inject.Inject;
//문자를 전송=>기간을 정하기
public class SystemMonitor {

	private long periodTime;//기간
	//has a 
	//@Inject
	private SmsSender sender;//byType
	
	//Setter Method 
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime() call");
	}

	@Inject
	 public void setSender(SmsSender sender) { this.sender = sender;
	 System.out.println("setSender() call=>"+sender); }
	 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SystemMonitor[periodTime="+periodTime+",sender="+sender+"]";
	}
}

package anno2;

import javax.inject.Inject;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;*/

//import javax.inject.Inject;//외부패키지
//문자를 전송=>기간을 정하기
public class SystemMonitor {

	private long periodTime;//기간
	//has a 
	//@Autowired(required=false)
	@Inject
	private SmsSender sender;//byType
	
	//Setter Method 
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime() call");
	}
	/*
	 * @Required
	 * @Autowired 
	 * public void setSender(SmsSender sender) { this.sender = sender;
	 * System.out.println("setSender() call=>"+sender); }
	 */
	 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SystemMonitor[periodTime="+periodTime+",sender="+sender+"]";
	}
}

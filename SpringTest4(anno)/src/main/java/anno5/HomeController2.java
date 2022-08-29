package anno5;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//형식)@Component("부여할 id 이름지정")=>지정X
//									기본클래스 이름을 통해 가져온다.
@Component
public class HomeController2 {

	@Inject
	private Camera camera;
	
	@Autowired
	private Camera camera2;
	
	@Autowired
	private Camera camera3;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HomeController2[camera="+camera+",camera2="+camera2+",camera3="+camera3;
	}
	
	
}

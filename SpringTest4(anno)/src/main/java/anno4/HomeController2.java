package anno4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class HomeController2 {

	private Camera camera;
	
	@Resource(name="camera5")//id가 camera5인 클래스 객체 찾아서 저장
	public void setCamera3(Camera camera) {
		this.camera = camera;
		System.out.println("setCamera() call");
	}
	
	//1.빈즈객체 생성 전에 초기화 작업을 하고자 할 때(=생성자)
	//물건 사기 전 돈 지불(=선불)
	@PostConstruct
	public void init() {
		System.out.println("빈즈 객체 생성 전에 초기화 작업");
	}
	
	//객체 생성된 후에 작업->메모리 작업->물건을 먼저 받고 나중에 돈 지불(후불)
	@PreDestroy
	public void close() {
		System.out.println("빈즈갹체 생성 후에 메모리 해제(close())");
	}
}

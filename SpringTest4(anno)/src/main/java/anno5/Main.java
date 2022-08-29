package anno5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.메모리 관리->xml파일이 여러개->배열로 관리->파일명 부여
		String [] configLocation=new String[] {"appScan.xml"};
		//2.xml파일을 메모리에 올려줄 수 있는 클래스를 통해서 객체를 생성
		AbstractApplicationContext context=new ClassPathXmlApplicationContext(configLocation);
		//3.자바프로그램이 종료->자동적으로 context객체도 같이 종료 설정
		context.registerShutdownHook();
		//4.xml에서 만들어진 객체를 가져와서 처리

		//형식) ~getBean("의존성객체를 얻어올 id",형변환을 할 클래스명.class)
		HomeController2 home2=context.getBean("home",HomeController2.class);
		System.out.println("home2=>"+home2);//10
		
		//5.context도 종료
		context.close();//메모리에 올려놓은 모든 빈즈 객체->메모리 해제
			}

	}



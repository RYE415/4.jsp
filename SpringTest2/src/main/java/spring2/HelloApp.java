package spring2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//스프링 방식=>객체를 생성->메서드를 호출
//->처리 방식을 xml파일로 설정(명세서)
public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.xml 파일의 위치를 불러오는 방법->절대경로(FileSystemResource)
		/*
		 * Resource resource=new FileSystemResource
		 * ("C:\\webtest\\4.jsp\\sou\\SpringTest\\src\\spring\\applicationContext.xml");
		 */
		Resource resource=new ClassPathResource
				("/spring2/initContext.xml");
		
		//2.빈즈공장을 불러와서 객체를 얻어오기//xml파일의 정보->메모리에 저장
		BeanFactory factory=new XmlBeanFactory(resource);
		//3.factory에서 getBean("불러올 객체를 가져올 id값")
		//Message1 me=new Message1();
		//Message1 me=(Message1)factory.getBean("test");//id가 test인 객체
		MessageBeanDI bean=(MessageBeanDI)factory.getBean("mbean");
		bean.sayHello();//생성자,setGreeting(안녕)=>sayHello()
		
	}

}

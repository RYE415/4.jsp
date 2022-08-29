package studentdb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.xml파일을 메모리에 로딩
		ApplicationContext context=new ClassPathXmlApplicationContext("/studentdb/Bean.xml");
		//2.xml->getBean(id 또는 name값)
		StudentJDBCTemplate st=(StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		
		System.out.println("st=>"+st);
		st.create(1,"홍길동",23);//pk가 충돌->무결성 제약조건
		st.create(2, "테스트", 34);
		st.create(3, "박영진", 45);
		st.create(4, "임시", 22);
		st.create(5, "테스트2", 32);
		
	
		
		System.out.println("전체 레코드 검색 중...");
		List<Student> sts=st.listStudents();//RowMapper(5번호출)
			for(Student re:sts) {//for(객체자료형 객체명:컬렉션객체명)
				System.out.println("id=>"+re.getId());//${re.id}
				System.out.println("name=>"+re.getName());
				System.out.println("age=>"+re.getAge());
			}
		//수정
		st.update(2,37);//id가 2번을 찾아서 나이를 37로 변경
		//삭제
		System.out.println("삭제시킬 Record 번호는 4번");
		st.delete(4);//내부적으로 update()호출
		//5번인 데이터를 검색하기
		Student re=st.getStudent(5);
		System.out.println("id=>"+re.getId());//${re.id}
		System.out.println("name=>"+re.getName());
		System.out.println("age=>"+re.getAge());
	}

}

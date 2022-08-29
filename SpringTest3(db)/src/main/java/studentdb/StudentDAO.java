package studentdb;

//import java.sql.*; //Connection,pstmt,stmt,rs
import javax.sql.DataSource;//DB연결할 때 필요(JNDI 방법 사용 시)
import java.util.List;//select 할 때

//DB연동의 초기화=>Student에 접속->DataSource객체->DB연동 O
public interface StudentDAO {

	//1.DB연결을 시켜주는 매서드 필요(초기화) DataSource객체->DB연동 O
	public void setDs(DataSource ds);
	
	//2.insert->create(Student st);
	public void create(Integer id,String name,Integer age);
	
	//3.학생정보->pk로 검색 select * from student where id=1
	public Student getStudent(Integer id);//~(int id);
	
	//4.학생들 전체 select * from student;
	public List<Student> listStudents();
	
	//5.학생정보 삭제 delete from student where id=2;
	public void delete(Integer id);
	//update(Student st)
	//6.학생정보를 수정->update 테이블명 set 필드명=값,,,where 조건식
	public void update(Integer id,Integer age);//(int,int)
}

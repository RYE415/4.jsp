package studentdb;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource ds;//DB접속->Bean.xml에서 가져옴
	//접속 후 sql실행=>pstmt와 비슷한 역할
	private JdbcTemplate jt;//query()(select)
	//query()(select),(insert,update,delete)->update()
	@Override
	public void setDs(DataSource ds) {
		// TODO Auto-generated method stub
		this.ds=ds;
		System.out.println("ds->"+ds);//null->DB설정값 오타 확인
		this.jt=new JdbcTemplate(ds);//JdbcTemplate(DB정보객체)
		System.out.println("setDS() call(ds->)"+ds);
	}
	@Transactional
	@Override
	public void create(Integer id, String name, Integer age) {
		// TODO Auto-generated method stub
	//형식)jdbcTemplate객체명.update(1.실행시킬sql구문,2.입력받은 값)
		String sql="insert into student values(?,?,?)";
		jt.update(sql,id,name,age);
		System.out.println("create id=>"+id+",name=>"+name+",age="+age);
				
	}
	
	//-------------select구문은 따로 RowMapper클래스를 이용해서 호출------------------------

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from student where id=?";
		/*
		 * 형식)반환값=jdbcTemplate객체명.queryForObject
		 * 			1)실행시킬 sql구문,매개변수(배열표시),RowMapper객체지정 
		 */
		//StudentRowMapper sm=new StudentRowMapper();
		Student st=jt.queryForObject(sql,new Object[] {id},new StudentRowMapper());
		return st;
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		String sql="select * from student";
		/*
		 * 형식)반환값=jdbcTemplate객체명.query
		 * 			1)실행시킬 sql구문,RowMapper객체지정 
		 */
		//StudentRowMapper sm=new StudentRowMapper();
		List<Student> sts=jt.query(sql,new StudentRowMapper());
		return sts;
	}

	//---------------------------------------------
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	String sql="delete from student where id=?";
	jt.update(sql,id);
	System.out.println("delete id=>"+id);
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String sql="update student set age=? where id=?";
		//pstmt.setInt(1,age),pstmt.setInt(2,id)
		jt.update(sql,age,id);
		System.out.println("change id=>"+id+",age="+age);
	}

}

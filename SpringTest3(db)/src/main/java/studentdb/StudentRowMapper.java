package studentdb;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//RowMapper인터페이스->select구문을 실행
//(mapRow()호출->DTO에 담아서 결과를 리턴

public class StudentRowMapper implements RowMapper {
	//callBack메서드=>내부적으로 자동적으로 호출해주는 메서드
	//1.mapRow(1.ResultSet객체를 반환 2.검색된 레코드 갯수=>갯수만큼 for문 돌려서 반환)
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("mapRow() call(rowNum)=>"+rowNum);
		//while(rs.next()){담아주는 구문}
		Student st=new Student();//DTO객체 생성=>검색된 갯수만큼 담기
		st.setId(rs.getInt("id"));
		st.setName(rs.getString("name"));
		st.setAge(rs.getInt("age"));
		
		return st;//query()의 반환값으로 전달받을 수 있다.
	}
}

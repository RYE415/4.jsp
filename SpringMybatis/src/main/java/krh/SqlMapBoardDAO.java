package krh;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

/*
 * SqlSessionDaoSupprot 상속
 * ->SqlSession 클래스 객체 필요->DB연동할 때 필요로 하는 객체
 */
public class SqlMapBoardDAO extends SqlSessionDaoSupport implements BoardDAO {

	//SqlSession sqlSession; =>getSqlSession()을 제공
	//setSqlSession(~){this.sqlSession=sqlSession;}
	
	@Override
	public List list() throws DataAccessException {
		// TODO Auto-generated method stub
		/*
		 * select->레코드 한개 이상(List)->selectList("실행시킬 sql구문 id")
		 * select->레코드 한개(DTO,String,Integer,,,)
		 * 		 ->selectOne("실행시킬 sql구문 id")
		 */
		return getSqlSession().selectList("list");
	
	}
}

package krh;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BoardDAO{
	
	//1.글 목록보기
	public List list() throws DataAccessException;//try~catch(X)
	
	//2.최대값 구하기
	
	
	//3.글쓰기,,,
	
}




/*
 * package krh;
 

//Connection,PreparedStatement,,,
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//ArrayList,List
import java.util.ArrayList;
import java.util.List;

//Context(인터페이스) or InitialContext객체(자식)
import javax.naming.Context;
import javax.naming.InitialContext;
////////////JNDI방법//////////////
//DataSource객체=>getConnection()
import javax.sql.DataSource;

//DataAccessException(스프링 전용 예외처리 클래스)
import org.springframework.dao.DataAccessException;
                                  //lookup('찾고자하는 jndi명')


/////////////////////////////////
public class BoardDAO{
	
   DataSource ds;//DBConnectionMgr pool;와 기능이 같다. has a 관계
   
   public BoardDAO(){
		//생성자:DataSource 얻기
	   try {
		   //InitialContext ctx=new InitialContext();
		   Context ctx=new InitialContext();
		   //형식) datasource객체명=(DataSource)ctx객체명.lookup("java:comp/env/찾고자하는 JNDI명")
		   ds=(DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
		   System.out.println("ds=>"+ds);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	}
   
   //public List  list(){
	public ArrayList  list(){  //글목록보기->레코드여러개 존재(ex 회원리스트,상품리스트,예약리스트)
		
		ArrayList list = new ArrayList();
		try{
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			//----------------------------------------------
			Connection con = ds.getConnection();
			//Connection con = pool.getConnection();
			//---------------------------------------------------
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){//더이상 불러올수 없을때까지
				Board data = new Board();
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
				data.setDate(rs.getString( "writeday" ));
				data.setReadcnt(rs.getInt( "readcnt" ));
				list.add( data );
			}//end while
			rs.close();	stmt.close(); con.close();//finally구분에 사용
		}catch(Exception e){ e.printStackTrace(); }
		
		return  list;//list.jsp에 출력
	}//end list
	
	public int getNewNum(){ //게시판의 글번호를 구해주는 메서드 따로 작성
		 int newNum=1;//저장할 게시물번호 디폴트 설정값 1
		 try {
			 String sql="select max(num) from springboard";
			 Connection con=ds.getConnection();
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 ResultSet rs=pstmt.executeQuery(sql);
			 if(rs.next()) {//레코드가 한개라도 존재한다면 최대값+1
				newNum=rs.getInt(1)+1;
			 }
		 }catch(Exception e) {e.printStackTrace();}
		 return newNum;
	}//end getNewNum();
	 //public void write(Board board){ ->정석
	public void write(String author, String title , String content){
		try{
			int newNum = this.getNewNum();
			//? 대신에 "  "=>콘솔에서 확인할 수 있도록 해주기위해서 ?을 안쓴건데->시큐어코딩
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println(sql);//한글이 깨지는지,제대로 값이 저장이 되는지 SQL구문
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement pstmt = con.prepareStatement(sql);
	  	  	pstmt.execute(sql);//pstmt.executeUpdate(sql);//정석
	  	  	pstmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	//select * from springboard where num=3;
	//public List<Board> ~
	public Board retrieve(String num){ // 글상세보기
		Board data=new Board();
		try {
			//1.조회수를 증가
			String sql="update springboard set readcnt=readcnt+1 where num="+num;
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			int update=pstmt.executeUpdate(sql);
			System.out.println("조회수 증가유무(update)=>"+update);//1 성공, 0 실패
			pstmt=null;//전에 저장된 정보를 제거
			
			sql="select * from springboard where num="+num;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		    if(rs.next()){//더이상 불러올수 없을때까지
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
			}//end while
			rs.close();	pstmt.close(); con.close();
			//2.조회수가 증가된 레코드를 찾아서 담기
		}catch(Exception e) {e.printStackTrace();}
	   return data;
	}//end retrieve
    //public void update(Board board){
	public void update( String num , String author, 
			                       String title , String content){ // 글수정하기
	     try{
		  String sql ="update springboard set title='" + title + "',";
		  sql += " content='" + content+"',";
		  sql += " author ='" + author+"'";
		  sql += " where num=" + num;
		  System.out.println(sql);//한글과 sql구문이 제대로 출력되는지 확인

		  Connection con = ds.getConnection();
		  PreparedStatement pstmt = con.prepareStatement(sql);  
		  int update=pstmt.executeUpdate(sql);
		  System.out.println("게시물수정유무(update)=>"+update);
		  pstmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update
     
	  //delete from springboard where num=3
	  public void delete( String num){ //글삭제
			try {
			   String sql="delete from springboard where num="+num;//?와 ?쓰지 않은경우 차이점
			   Connection con=ds.getConnection();
			   PreparedStatement pstmt=con.prepareStatement(sql);
			   int delete=pstmt.executeUpdate(sql);
			   System.out.println("delete 삭제유무(delete)=>"+delete);//1성공, 0 실패
			   pstmt.close(); con.close();
			}catch(Exception e) {e.printStackTrace();}
		}//end delete
    
	  //검색어를 입력해서 검새하는 경우
	  //public List<Board>
	  public ArrayList search( String name , String value ){ //검색분야,검색어
		    ArrayList list = new ArrayList();
		    try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println( sql );//sql구문을 통해서 값이 제대로 전달되는지 확인->로그객체
		  
			      Connection con = ds.getConnection();
		    	  PreparedStatement stmt = con.prepareStatement(sql);
		    	  ResultSet rs = stmt.executeQuery( sql );
		    	  while( rs.next()){
		    		Board data = new Board();
		    		data.setNum(rs.getInt( "num" ));
		    		data.setAuthor(rs.getString( "author" ));
		    		data.setTitle(rs.getString( "title"));
		    		data.setContent(rs.getString( "content" ));
		    		data.setDate(rs.getString( "writeday" ));
		    		data.setReadcnt(rs.getInt( "readcnt" ));
		    		list.add( data );
		    	  }
		    	  rs.close();	stmt.close(); con.close();
		    	}catch( Exception e){ e.printStackTrace();}
		    	return list;
    }
}



*/












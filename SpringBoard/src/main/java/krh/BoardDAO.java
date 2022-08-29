package krh;

import java.sql.*;//Connection,PreparedStatement,,,
import java.util.*;//ArrayList,List
////////////JNDI방법//////////////
import javax.sql.*;//DataSource객체=>getConnection()
import javax.naming.*;//Context(인터페이스) or InitialContext객체(자식)
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
	
	public int getNewNum(){ //글쓰기 번호 얻기
		int newNum=1;//저장할 게시물 번호 디폴트 설정값1
		try {
			String sql="select max(num) from springboard";
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				newNum=rs.getInt(1)+1;
			}
		}catch(Exception e) {e.printStackTrace();}
		return newNum;
	}//end getNewNum();
	  
	public void write(String author, String title , String content){
		try{
			int newNum = getNewNum();
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println(sql);//sql구문을 통한 데이터 입력값 확인
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement stmt = con.prepareStatement(sql);
	  	  	stmt.execute(sql);
	  	  	stmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	
	//글 상세보기->1.조회수증가 2.검색해서 화면에 출력
	public Board retrieve(String num){ // 글 자세히 보기
		Board data=new Board();
		try {
			String sql="update springboard set readcnt=readcnt+1 where num="+num;
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			int update=pstmt.executeUpdate(sql);//1 성공 0 실패
			System.out.println("조회수 증가 유무(update)=>"+update);
			pstmt=null;//전에 저장된 정보를 제거
			sql="select * from springboard where num="+num;
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	
	}//end retrieve
	
	public void update( String num , String author, 
			            String title , String content){ // 글 수정하기
	     try{
		  String sql ="update springboard set title='" + title + "',";
		  sql += " content='" + content+"',";
		  sql += " author ='" + author+"'";
		  sql += " where num=" + num;
		  System.out.println(sql);

		  Connection con = ds.getConnection();
		  PreparedStatement stmt = con.prepareStatement(sql); 
		  int update=stmt.executeUpdate(sql);
		  System.out.println("데이터수정유무(update)=>"+update);
		  stmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update
	
	  public void delete( String num){ //글 삭제하기
			try {
				String sql="delete from springboard where num="+num;
				Connection con=ds.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				int delete=pstmt.executeUpdate(sql);//1:성공
				System.out.println("데이터삭제유무(delete)=>"+delete);
				pstmt.close(); con.close();
			}catch(Exception e) {e.printStackTrace();}
			
			}//end delete
	  
    //1.name(검색분야) 2.value(검색어)
	  public ArrayList search( String name , String value ){ //검색하기
		  ArrayList list=new ArrayList();//한개이상  
		  try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println( sql );//한글처리,sql구문 확인 
		  
			      Connection con = ds.getConnection();
		    	  PreparedStatement stmt = con.prepareStatement(sql);
		    	  ResultSet rs = stmt.executeQuery( sql );
		    	  while( rs.next()){
		    		Board data = new Board();//DTO
		    		data.setNum(rs.getInt( "num" ));
		    		data.setAuthor(rs.getString( "author" ));
		    		data.setTitle(rs.getString( "title"));
		    		data.setContent(rs.getString( "content" ));
		    		data.setDate(rs.getString( "writeday" ));
		    		data.setReadcnt(rs.getInt( "readcnt" ));
		    		list.add(data);//NullPointer 에러유발
		    	  }
		    	  rs.close();	stmt.close(); con.close();
		    	}catch( Exception e){ e.printStackTrace();}
		    	return list;
    }
 
}
















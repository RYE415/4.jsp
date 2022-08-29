package krh;

import java.sql.*;//Connection~
import java.util.*;//ArrayList,List~

////////JNDI 방법////////
import javax.sql.*;//DataSource객체->getConnection()
import javax.naming.*;//Context(인터페이스),InitialContext(자식)
					  //jdbc/orcl=>lookup('찾고자 하는 jndl명')
////////////////////////

public class BoardDAO{
   
   DataSource ds;//DBConnectionMgr pool; 와 기능이 같다.
   
   public BoardDAO(){
		//생성자 : DataSource 얻기 :  InitialContext  와  JNDI 명
		try {
			//InitialContext ctx=new InitialContext();
			Context ctx=new InitialContext();
		//ds=(DataSource)ctx.객체명("java:component/env/jdbc/orcl")  
		ds=(DataSource)ctx.lookup("java:component/env/jdbc/orcl");
		System.out.println("ds=>"+ds);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList  list(){  // 목록보기 
		
		ArrayList list = new ArrayList();
		try{
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Board data = new Board();
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
				data.setDate(rs.getString( "writeday" ));
				data.setReadcnt(rs.getInt( "readcnt" ));
				list.add( data );
			}//end while
			rs.close();	stmt.close(); con.close();
		}catch(Exception e){ e.printStackTrace(); }
		
		return  list;
	}//end list
	/*
	public int getNewNum(){ //글쓰기 번호 얻기
		
	}//end getNewNum();
	  
	public void write(String author, String title , String content){
		try{
			int newNum = getNewNum();
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println(sql);
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement stmt = con.prepareStatement(sql);
	  	  	stmt.execute(sql);
	  	  	stmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	
	public Board retrieve(String num){ // 글 자세히 보기 
		
	
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
		  stmt.executeUpdate(sql);
		  stmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update

	  public void delete( String num){ //글 삭제하기
			
		}//end delete
    
	  public ArrayList search( String name , String value ){ //검색하기
		    ArrayList list = new ArrayList();
		    try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println( sql );
		  
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
*/
}

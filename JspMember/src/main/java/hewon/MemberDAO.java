package hewon;//같은 패키지이기에 import X

//웹상에서 호출할 메서드를 작성해서 불러다 사용할 클래스(DAO역할)
import java.sql.*;//DB관련
import java.util.*;//자료구조-> ArrayList,Hashtable,,,


public class MemberDAO {//XXXXMgr or XXXXDAO
	
	//1.멤버변수에 연결할 클래스의 객체를 선언(has a 관계)
	private DBConnectionMgr pool=null;
	//getConnection,freeConnection() 때문에 필요
	
	//2.공통으로 접속할 경우 필요로 하는 멤버변수 선언
	private Connection con=null;
	private PreparedStatement pstmt=null;//for SQL 구문 실행
	//Statement보다 PreparedStatement가 더 유리-> 데이터 관리 good
	private ResultSet rs=null;//select 구문
	private String sql="";//실행시킬 SQL 구문 저장 목적
	
	//3.생성자를 통해서 자동으로 연결하고자 하는 객체를 얻어올 수 있도록 코딩
	public MemberDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB연결실패=>"+e);//e.toString()
		}
	}
	//3.요구 분석에 따른 웹 상에서 호출할 메서드를 작성
	//1)회원 로그인
	//sql>select id from member where id=? and password=?
	//sql구문->select구문->반환값O where 조건식 매개변수 O(2개)
	public boolean loginCheck(String id,String passwd) {
		//1.DB연결
		boolean check=false;
		//2.SQL 실행=>결과(웹에 리턴O or 리턴X)
		try {
			con=pool.getConnection();//이미 만들어진 Connection 반환
			System.out.println("con=>"+con);
			sql="select id from member where id=? and passwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs=pstmt.executeQuery();
			check=rs.next();//데이터가 존재 true or 없으면 false
				
		}catch(Exception e) {
			System.out.println("loginCheck() 실행에러유발=>"+e);
		}finally {//3.메모리해제
			pool.freeConnection(con,pstmt,rs);
		}return check;
}
	
	//2)중복 id 체크
	//select id from member where id='nup';
	public boolean checkId(String id) {
		boolean check=false;//중복 id 체크유무
		try {
			con=pool.getConnection();
			sql="select id from member where id=?";
			//con.prepareStatement(실행시킬SQL구문)
			//아래 pstmt 없으면 NullPointerException발생
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);//1.?의 순서 2.저장할 값(매개변수명)
			rs=pstmt.executeQuery();
			check=rs.next();//true->id 존재 or 없으면 false
		}catch(Exception e) {
			System.out.println("checkId()실행에러유발=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return check;//IdCheck.jsp에서 받아서 존재유무확인
	}
	
	
	//3)우편번호 검색
	//select * from zipcode where area3 like '%미아2동%'
	//레코드가 한개 ZipcodeDTO, 필드 1개-> 자료형,필드 2개->DTO
	//레코드가 한개 이상-> 동적(Vector,ArrayList)
	public ArrayList<ZipcodeDTO> zipcodeRead(String area3){
		//레코드 한개 이상 담을 변수(객체)선언
		ArrayList<ZipcodeDTO> zipList=new ArrayList();//미리 생성
		try {
			con=pool.getConnection();
			//select * from zipcode where area3 like '%미아2동%'
			sql="select * from zipcode where area3 like '"+area3+"%'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("검색된 sql 구문 확인=>"+sql);
			//검색된 레코드의 값을 필드별로 담는 소스코드
			//->찾은 레코드 1개(if(rs.next()),1개이상 while(rs.next())
			while(rs.next()) {
				ZipcodeDTO tempZipcode=new ZipcodeDTO();
				tempZipcode.setZipcode(rs.getString("zipcode"));//142-102
				tempZipcode.setArea1(rs.getString("area1"));//시 부적합열
				tempZipcode.setArea2(rs.getString("area2"));
				tempZipcode.setArea3(rs.getString("area3"));
				tempZipcode.setArea4(rs.getString("area4"));
				//ArrayList에 담는 구문을 작성
				zipList.add(tempZipcode);//Null이 출력됨
			}
		}catch(Exception e) {
			System.out.println("zipcodeRead()실행에러유발=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return zipList;
	}
	
	//4)회원가입->insert into member values(?,?,?,,,,)->매개변수O
	//							    (String id,String pw,,,)
	//DTO 1)테이블의 필드별로 저장 2)메서드의 매개변수,반환형으로 사용
	public boolean memberInsert(MemberDTO mem) {
		boolean check=false;//회원가입 성공유무
		//추가->트랜잭션을 처리
		try {
			con=pool.getConnection();
			//트랜잭션 처리->setAutoCommit(false)=>default:true
			con.setAutoCommit(false);
			//-----------------------------------------
			sql="insert into member values(?,?,?,?,?,?,?,?)";
			//con.prepareStatement(실행시킬SQL구문)
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, mem.getMem_id());
			pstmt.setNString(2, mem.getMem_passwd());
			pstmt.setNString(3, mem.getMem_name());
			pstmt.setNString(4, mem.getMem_email());
			pstmt.setNString(5, mem.getMem_phone());
			pstmt.setNString(6, mem.getMem_zipcode());
			pstmt.setNString(7, mem.getMem_address());
			pstmt.setNString(8, mem.getMem_job());
			//반환갑 1(성공) 0(실패)
			int insert=pstmt.executeUpdate();
			con.commit();//mysql인 경우에는 생략
			System.out.println("insert(데이터 입력유무)=>"+insert);
			if(insert > 0) {//if(insert==1){
				check=true;//데이터 성공 확인 
			}
			
		}catch(Exception e) {
			System.out.println("memberInsert()실행에러유발=>"+e);
		}finally {
			pool.freeConnection(con,pstmt);
		}
		return check;//memberInsert.jsp에서의 메서드 반환값
	}

	//5)회원 수정-> 특정 회원 찾기
	//select * from member where id='nup' //select * from 테이블명 where id='?'
	//select->반환값 O, where->매개변수 1개
	//public Scanner getScanner(){return ~}
	public MemberDTO getMember(String mem_id) {
		MemberDTO mem=null;//id값에 해당되는 레코드 한개를 저장
		try {
			con=pool.getConnection();
			sql="select * from member where id=?";
			//con.prepareStatement(실행시킬SQL구문)
			//아래 pstmt 없으면 NullPointerException발생
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, mem_id);//1.?의 순서 2.저장할 값(매개변수명)
			rs=pstmt.executeQuery();
			//레코드를 찾았다면
			if(rs.next()) {
			//찾은 값->SetterMethod의 매개변수로 저장->Getter Method
				mem=new MemberDTO();
				mem.setMem_id(rs.getString("id"));
				mem.setMem_passwd(rs.getString("passwd"));
				mem.setMem_name(rs.getString("name"));
				mem.setMem_phone(rs.getString("phone"));
				mem.setMem_zipcode(rs.getString("zipcode"));
				mem.setMem_address(rs.getString("address"));
				mem.setMem_email(rs.getString("e_mail"));	
				mem.setMem_job(rs.getString("job"));
				
			}
		}catch(Exception e) {
			System.out.println("getMember()실행에러유발=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return mem;//MemberUpdate.jsp에서 메서드 반환형
	}
	
	
	//6)찾은 회원 수정=>회원가입해주는 메서드와 동일(sql 구문이 다르다.)
	public boolean memberUpdate(MemberDTO mem) {
			boolean check=false;//회원수정 성공유무
			//추가->트랜잭션을 처리
			try {
				con=pool.getConnection();
				//트랜잭션 처리->setAutoCommit(false)=>default:true
				con.setAutoCommit(false);
				//-----------------------------------------
				sql="update member set passwd=?,name=?,e_mail=?,"
					+"phone=?,zipcode=?,address=?,job=? where id=?";
				//con.prepareStatement(실행시킬SQL구문)
				pstmt=con.prepareStatement(sql);
				
				pstmt.setNString(1, mem.getMem_passwd());
				pstmt.setNString(2, mem.getMem_name());
				pstmt.setNString(3, mem.getMem_email());
				pstmt.setNString(4, mem.getMem_phone());
				pstmt.setNString(5, mem.getMem_zipcode());
				pstmt.setNString(6, mem.getMem_address());
				pstmt.setNString(7, mem.getMem_job());
				pstmt.setNString(8, mem.getMem_id());
				//반환갑 1(성공) 0(실패)
				int update=pstmt.executeUpdate();
				con.commit();//mysql인 경우에는 생략
				System.out.println("update(데이터 수정유무)=>"+update);
				if(update==1) {
					check=true;//데이터 수정성공 확인 
				}
				
			}catch(Exception e) {
				System.out.println("memberUpdate()실행에러유발=>"+e);
				try {con.rollback();}catch(Exception e2) {e2.printStackTrace();}
			}finally {
				pool.freeConnection(con,pstmt);
			}
			return check;//memberInsert.jsp에서의 메서드 반환값
		}

	
	
	
	//7)회원 탈퇴=>게시판의 글 수정, 글 삭제하기와 소스코드가 동일
	//select passwd from member where id='nup'
	//delete from member where id='nup'
	public int memberDelete(String id,String passwd) {
		String dbpasswd="";//DB상에서 찾은 암호
		int x=-1;//회원 탈퇴 유무
		
		try {
			con=pool.getConnection();//커넥션풀(미리 만들어서 주는 경우)
			con.setAutoCommit(false);
			sql="select passwd from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//암호를 찾았다면
			if(rs.next()) {
				dbpasswd=rs.getString("passwd");
				System.out.println("dbpasswd=>"+dbpasswd);
				//dbpasswd==passwd(웹상 암호)
				if(dbpasswd.equals(passwd)) {
					sql="delete from member where id=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs=pstmt.executeQuery();
					int delete=pstmt.executeUpdate();
					System.out.println("delete(회원탈퇴성공유무)=>"+delete);//1
					con.commit();//실제 테이블에 반영
					x=1;//회원 탈퇴 성공
				}else {//암호 틀린 경우
					x=0;//회원탈퇴실패
				}
				}else {//암호가 존재X
					x=-1;
				}
		
		
			}catch(Exception e) {
			System.out.println("memberDelete() 에러유발=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return x;
	}
	
	
	
	//8)회원리스트 => 과제)게시판의 글 목록 보기->테이블의 필드,형태만 변경

}

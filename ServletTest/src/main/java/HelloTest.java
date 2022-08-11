/*
 * 서블릿=>서버에서 실행되어서 그 실행 결과(text/html)를 브라우저로 재전송해주는 프로그램
 * 서블릿을 만드는 조건(servlet-api.jar) -> classpath에 외부파일로 추가
 * 
 * 서블릿을 만드는 3가지의 특징을 기술하시오.
 * 
 * 1.import javax.servlet.*;//서블릿 클래스 정보
 * 	 import javax.servlet.http.*;//웹상에서의 접속에 관련된 정보 클래스
 * 
 * 2.반드시 public class로 작성해야 한다. =>외부에서 접근 가능하게 해주기 때문에
 * 3.반드시 HttpServlet 클래스를 상속 받아야 한다.->doGet(),doPost() 때문
 * 
 * get방식(사이트 접속)->doGet()자동으로 호출=>객체명.메서드명()(x)
 * post방식(ex 회원가입,로그인) -> doPost() 자동으로 호출
 * 
 */

import java.io.IOException; //입출력 예외 처리 가능성 많음.
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;//서블릿의 초기환경설정할 때 필요
import javax.servlet.ServletException;//서블릿의 오류 발생 시 처리
import javax.servlet.annotation.WebServlet;//웹상에서 서블릿을 실행하기 위해서 접근?
import javax.servlet.http.HttpServlet;//상속을 받을 서블릿 클래스
import javax.servlet.http.HttpServletRequest;//요청을 받아서 처리해주는 객체(request)
import javax.servlet.http.HttpServletResponse;//응답을 받아서 처리해주는 객체(response)

/**
 * Servlet implementation class HelloTest
 */
@WebServlet("/test/imsi/haha/HelloTest")
public class HelloTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿이 실행 시 제일 먼저 호출되는 메서드(init)");
		System.out.println("생성자와 같은 역할(서블릿의 초기값을 설정)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("소스코드를 변경해서 다시 새로고침해서 확인(reload)");
		System.out.println("서블릿이 종료할 때(메모리 해제할 때 사용)");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("웹상에서 get방식으로 접속할 때 자동으로 호출");
		//1.어떤 형태의 문서를 보내줄 지 결정
		response.setContentType("text/html;charset=utf-8");
		//2.PrintWriter out=new getWriter();//출력객체
		PrintWriter out=response.getWriter();
		//3.html문서로
		out.println("<html><head></head>");
		out.println("<body>");
		//서블릿의 기능을 작성해준다.
		out.println("<h2>Hello Servlet 테스트</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

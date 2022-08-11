

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDate
 */
@WebServlet("/GetDated")
public class GetDate2 extends HttpServlet {


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("웹상에서 get방식으로 접속할때 자동으로 호출");
		//1.어떤형태의 문서를 보내줄지 결정
		response.setContentType("text/html;charset=utf-8");
		//2.PrintWriter out=new PrintWriter();
		PrintWriter out=response.getWriter();//출력객체
		//3.html문서로 만들어준다.
		out.println("<html><head></head>");
		out.println("<body>");
		//서블릿의 기능을 작성해준다.
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		out.println("name=>"+name+",addr=>"+addr);
		//---------------------------------------------------
		out.println("</body>");
        out.println("</html>");
	}
}



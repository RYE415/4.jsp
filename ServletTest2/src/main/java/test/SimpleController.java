package test;

import java.io.IOException;
import javax.servlet.*;//서블릿
import javax.servlet.annotation.WebServlet;//서블릿요청경로
import javax.servlet.http.*;//요청(httpServlet)을 받아서 처리

/**
 * Servlet implementation class SimpleController
 */
@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
		
	}
	
	//Get or Post와 상관없이 동일한 처리(~.jsp(X) ~.do(요청명령어)
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1.요청명령어를 입력을 받아서 분석(매개변수로 전달)
		String type=request.getParameter("type");
		System.out.println("type=>"+type);
		//greeting->안녕하세요,date->오늘날짜 출력,X->에러메세지 출력
		
		//2.요청결과에 따른 요청값을 저장할 변수 선언
		Object resultObject=null;//String or java.util.Date(둘가능)
		//3. 요청 명령어 분리
		if(type==null || type.contentEquals("greeting")) {
			resultObject="안녕하세요!!!";
		}else if(type.contentEquals("date")) {
			resultObject=new java.util.Date();
		}else {
			resultObject="Invalid Type";
		}
		//4.처리결과->어떻게 jsp에 전송해줄까?
		request.setAttribute("result",resultObject);//forward
		//5.forward액션태그 X->forward시켜주는 객체가 필요(RequestDispatcher클래스)
		//getRequestDispatcher("\이동할 페이지명")=>이동할 페이지 정보
		RequestDispatcher dispatcher=request.getRequestDispatcher("/simple.jsp");
		//6.forward메서드->데이터를 공유시키면서 페이지를 이동시킬 수 있다.
		dispatcher.forward(request, response);
	}
	
}



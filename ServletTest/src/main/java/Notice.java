

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h2>오늘의 공지사항</h2>");
		//notice->202275.txt
		String fileName="";//불러올 파일명 저장
		Calendar cal=Calendar.getInstance();//Date d=new Date();
		//형식)날짜객체명.get(정적상수명)""+"2022"
		fileName+=cal.get(Calendar.YEAR);//2022
		fileName+=cal.get(Calendar.MONTH)+1;//0~11 +1(2022)
		fileName+=cal.get(Calendar.DATE);//윤년도 자동계산
		fileName+=".txt";//"202275.txt"
		String realPath="C:/webtest/4.jsp/sou/ServletTest/src/main/webapp/notice/"+fileName;
		System.out.println("realPath=>"+realPath);
		
		try {
			//FileInputStream(영문) or FileReader(한글)
			BufferedReader br=new BufferedReader(new FileReader(realPath));
			String line="";//한줄씩 읽어들여서 저장할 변수
			//계속 불러올 수 있을 때까지
			while((line=br.readLine())!=null) {
				out.println(line+"<br>");//접속자(클라이언트의 컴퓨터브라우저)
			}
			br.close();
		}catch(IOException e) {
			System.out.println("불러올 파일의 경로와 파일명을 다시 확인"+e);
		}catch(Exception e) {
			System.out.println("오늘은 공지사항이 없습니다.");
			
		}
		out.println("<p align=center>");
		out.println("<hr>");
		out.println("<input type='submit' value='창닫기' onclick='window.close()'>");
		
		
		
		out.println("</body>");
		out.println("</html>");
	}

}

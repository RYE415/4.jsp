package krh;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction(페이지 이동,클래스는 틀리지만 처리메서드동일)
public class DeleteActionController implements Controller {
	
	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {//<property name="dao"><ref bean="id명" />~
		this.dao=dao;
		System.out.println("setDao() 호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("DeleteActionController의 handleRequest()호출됨");
		//->/delete.do?num=3
		String num=request.getParameter("num");
		dao.delete(num);
		//화면에 출력할 list.jsp에 전달할 페이지명과 전달할값을 설정
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/list.do");//경로? 확장자?
		
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}
}






package krh;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction(페이지 이동,클래스는 틀리지만 처리메서드동일)
public class RetrieveActionController implements Controller {
	
	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {//<property name="dao"><ref bean="id명" />~
		this.dao=dao;
		System.out.println("setDao() 호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("RetrieveActionController의 handleRequest()호출됨");
		//글 상세보기 메서드 호출->/retrieve.do?num=3
		//ArrayList list=dao.list();
		String num=request.getParameter("num");
		Board data=dao.retrieve(num);
		//화면에 출력할 list.jsp에 전달할 페이지명과 전달할값을 설정
		/*
		ModelAndView mav=new ModelAndView();
		mav.setViewName("retrieve");//이동할 페이지명만 지정=>경로? 확장자?
		*/
		//생성자(이동할 페이지명(=redirect:/요청명령어))
		ModelAndView mav=new ModelAndView("retrieve");
		mav.addObject("data",data);//request.setAttribute("list",list);
		//${list(키명)}
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}
}






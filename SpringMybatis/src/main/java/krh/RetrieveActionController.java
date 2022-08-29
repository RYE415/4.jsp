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
		 // retrieve.do?num=3
		String num=request.getParameter("num");
		//ArrayList list=dao.list();
		Board data=dao.retrieve(num);//게시물번호에 해당되는 레코드 한개
		//화면에 출력할 list.jsp에 전달할 페이지와 전달할값을 설정하기위해서 필요
		/*
		ModelAndView mav=new ModelAndView();
		mav.setViewName("retrieve");
		*/
		ModelAndView mav=new ModelAndView("retrieve");//생성자(이동할 페이지명)
		//모델2=>request.setAttribute("키명",저장할값)->request.getAttribute("키명")
		mav.addObject("data",data);//request.setAttribute("list",list);
		//${list(키명)}
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}
}






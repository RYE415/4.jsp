package krh;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


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
		 // delete.do?num=3
		String num=request.getParameter("num");
		//ArrayList list=dao.list();
		dao.delete(num);//게시물번호에 해당되는 레코드 한개
		
		ModelAndView mav=new ModelAndView();//생성자(이동할 페이지명)
		mav.setViewName("redirect:/list.do");//삭제->ListActionController->/list.jsp
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}
}






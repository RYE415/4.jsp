package krh;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction(페이지 이동,클래스는 틀리지만 처리메서드동일)
public class SearchActionController implements Controller {
	
	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {//<property name="dao"><ref bean="id명" />~
		this.dao=dao;
		System.out.println("setDao() 호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("SearchActionController의 handleRequest()호출됨");
		//추가(검색분야,검색어에 해당하는 레코드만 보여줄 수있도록)
		String searchName=request.getParameter("searchName");//검색분야
		String searchValue=request.getParameter("searchValue");//검색어
		//--------------------------------------------------------------------
		ArrayList list=dao.search(searchName,searchValue);
		//--------------------------------------------------------------------
		//화면에 출력할 list.jsp에 전달할 페이지와 전달할값을 설정하기위해서 필요
		ModelAndView mav=new ModelAndView();//이동할페이지,화면에 출력할 데이터를 임시저장
		mav.setViewName("list");//이동할 페이지명만 지정=>경로? 확장자?
		//모델2=>request.setAttribute("키명",저장할값)->request.getAttribute("키명")
		mav.addObject("list",list);//request.setAttribute("list",list);
		//${list(키명)}
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}
}






package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestActionController implements Controller {

	//요청받아서 처리해주는 메서드(request,response객체)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestActionController의 handleRequest()호출됨");
		ModelAndView mav=new ModelAndView();//이동할 페이지,화면에 출력할 데이터전달
		mav.setViewName("list3");//이동할 페이지명만 지정=>경로?,확장자?->viewResolver
		//모델2=>request.setAttribute("키명",저장할값)->request.getAttribute("키명")
		mav.addObject("greeting","스프링세상!!!");//request.setAttribute("greeting","스프링세상!!!");
		
		return mav;//return "/list.jsp"->viewResolver가 분리 /list3.jsp
	}
}

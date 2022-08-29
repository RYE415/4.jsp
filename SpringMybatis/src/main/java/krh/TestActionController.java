package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction(페이지 이동,클래스는 틀리지만 처리메서드동일)
public class TestActionController implements Controller {

	 //요청받아서 처리해주는 메서드(request객체,response객체)
	//public String requestPro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestActionController의 handleRequest()호출됨");
		ModelAndView mav=new ModelAndView();//이동할페이지,화면에 출력할 데이터를 임시저장
		//<property name="viewName" value="list3" />
		mav.setViewName("list3");//이동할 페이지명만 지정=>경로? 확장자?
		//모델2=>request.setAttribute("키명",저장할값)->request.getAttribute("키명")
		mav.addObject("greeting","스프링 세상!");//request.setAttribute("greeting","스프링 세상!");
		return mav; //return "/list.jsp";->viewResolver가 분리 /list3.jsp
	}

}






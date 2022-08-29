package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction
public class TestActionController implements Controller {

	//public String requestPro(~
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestActionController의 handleRequest()호출됨");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("list3");//이동할 페이지명만 지정
		//어떤 경로? 어떤 확장자->viewResolver
		//모델2->request.setAttribute("키명",저장할값)
		mav.addObject("greeting","스프링세상!!!");
		//<->request.getAttribute(키명)
		return mav;//return "/list.jsp"
}
}

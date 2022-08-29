package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloActionController implements Controller {

	//요청받아서 처리해주는 메서드(request,response객체)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HelloActionController의 handleRequest()호출됨");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("message","클릭하나!!!");
		
		return mav;
	}
}

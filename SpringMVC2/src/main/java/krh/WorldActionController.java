package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WorldActionController implements Controller {

	//요청받아서 처리해주는 메서드(request,response객체)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WorldActionController의 handleRequest()호출됨");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("world");
		mav.addObject("message2","클릭둘!!!");
		
		return mav;
	}
}

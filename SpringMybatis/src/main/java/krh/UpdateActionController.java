package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

//  /update.do
public class UpdateActionController extends AbstractCommandController {
   //<property name="commandClass" value="lee.BoardCommand" />
	// setCommandClass(BoardCommand command) 상속받아서 이미 존재하기에 코딩 안해도 된다.
    BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {//<property name="dao"><ref bean="id명" />~
		this.dao=dao;
		System.out.println("setDao() 호출됨(dao)=>"+dao);
	}
	
	//1.request(요청객체) 2.response(응답객체) 3.입력받은 값을 저장한 객체(Object(다 입력이 가능O)
	//4.BindException->사용자로부터 값을 입력시 에러발생->에러를 처리해주는 객체
	@Override
	protected ModelAndView handle(HttpServletRequest request, 
			                                         HttpServletResponse response,
			                                         Object command, BindException error)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateActionController 실행됨!");
		request.setCharacterEncoding("utf-8");//한글처리
		BoardCommand data=(BoardCommand)command;//이미 입력받은값을 Setter Method로 호출이 돼서 저장이 된상태
		///추가 (게시물번호가 전달->hidden객체 or 읽기전용 input box이용)
		String num=request.getParameter("num");
		//----------------------------------------------------
		String author=data.getAuthor();//작성자
		String title=data.getTitle();
		String content=data.getContent();
		
		//메서드 호출 update(~)
		dao.update(num,author, title, content);//dao.update(data);
		return new ModelAndView("redirect:/list.do");
	}
}





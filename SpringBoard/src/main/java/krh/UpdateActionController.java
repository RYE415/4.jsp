package krh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
/*
 * 입력을 받아서 처리(글쓰기,글수정,회원가입,회원수정,로그인)->AbstractCommandController을 상속받는다.
 * 입력X 처리(페이지 이동(글쓰기폼),글 상세보기,글 삭제)	
 */
public class UpdateActionController extends AbstractCommandController {
	/*	상속 때문에 부모의 멤버변수,메서드를 이미 가지고 있는 상태
	 *  <property name="commandClass"
  			value="krh.BoardCommand" />
  		setCommandClass(BoardCommand command) 호출
	 */
	BoardDAO dao;
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao() write call");
	}

	//1.request(요청객체),2.response(응답객체)
	//3.입력받은 값을 저장한 객체(Object->다 저장이 가능하게 설정)
	//4.BindException -> 사용자로부터 값을 입력 시 에러발생->예외처리클래스
	@Override
	protected ModelAndView handle(HttpServletRequest request, 
								  HttpServletResponse response, 
								  Object command, 
								  BindException error)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateActionController execute");
		request.setCharacterEncoding("utf-8");//한글
		BoardCommand data=(BoardCommand)command;
		//추가(게시물 번호가 전달->hidden 객체 or 읽기전용 inputbox 전달)
		String num=request.getParameter("num");
		String author=data.getAuthor();
		String title=data.getTitle();
		String content=data.getContent(); 
		/*
		 * BoardCommand command=new BoardCommand();
		 * String author=request.getParameter("author");
		 * command.setAuthor(author);
		 * ,,,
		 */
		
		dao.update(num, author, title, content);//dao.write(data);
		//response.sendRedirect("list.jsp")
		//=>형식)redirect:/요청명령어->/list.jsp
		/*
		//글쓰기버튼->/write.do(저장)->/list.do->ListActionController->/list.jsp
		ModelAndView mav=new ModelAndView("redirect:/list.do");//404
				
		return mav;
		*/
		return new ModelAndView("redirect:/list.do");
	}

}

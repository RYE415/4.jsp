<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Timestamp,krh.board.*"%>

 <%
 	request.setCharacterEncoding("utf-8");//한글처리
 	//BoardDTO=>SetterMethod(5)+hidden(num)+action(pageNum)
 	//BoardDAO=>insertArticle(BoardDTO 객체)호출
 %>
 <jsp:useBean id="article" class="krh.board.BoardDTO" />
 <jsp:setProperty name="article" property="*" />
 <%
 String pageNum=request.getParameter("pageNum");//멤버변수X
 System.out.println("updatePro.jsp의 pageNum="+pageNum);
 BoardDAO dbPro=new BoardDAO();
 int check=dbPro.updateArticle(article);//수정유무
 if(check==1){//글 수정에 성공했다면
 //response.sendRedirect("list.jsp");//입력한 후 다시 자동 DB접속-> 출력
 //http-equiv="Refresh"새로고침
 //content="초단위(몇초동안 멈춘 후);url=이동할 페이지?매개변수명=값"
 %>
 <meta http-equiv="Refresh"
 content="0;url=list.jsp?pageNum=<%=pageNum%>">
 <%}else{%>
 <script>
 alert("비밀번호가 맞지 않습니다.\n다시 비밀번호를 확인요망");
 history.go(-1);
 </script>
 <%}%>
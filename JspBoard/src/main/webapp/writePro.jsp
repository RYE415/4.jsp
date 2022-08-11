<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Timestamp,krh.board.*"%>

 <%
 	request.setCharacterEncoding("utf-8");//한글처리
 	//BoardDTO=>SetterMethod(5)+hidden(4)=9개
 	//BoardDAO=>insertArticle(BoardDTO 객체)호출
 %>
 <jsp:useBean id="article" class="krh.board.BoardDTO" />
 <jsp:setProperty name="article" property="*" />
 <%
 //readcount(0) 생략,오늘날짜,원격주소 ip
 Timestamp temp=new Timestamp(System.currentTimeMillis());
 article.setReg_date(temp);//오늘 날짜 수동 저장
 article.setIp(request.getRemoteAddr());//원격ip
 
 BoardDAO dbPro=new BoardDAO();
 dbPro.insertArticle(article);
 response.sendRedirect("list.jsp");//입력한 후 다시 자동 DB접속-> 출력
 
 
 %>
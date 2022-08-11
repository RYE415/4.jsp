<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지를 이동시키는 역할</title>
</head>
<body>
  <h1>페이지 이동</h1>
  <%
  String move=request.getParameter("move");//a.jsp or b.jsp
  System.out.println("move=>"+move);//null or a.jsp
  //reponse.sendRedirect("a.jsp");//단순히 이동만 시킬 때 사용
  if(move.equals("a.jsp")){
  %>
  <!-- forward 액션태그명 page="이동할 페이지명"(데이터를 공유하면서 이동) -->
  	 <jsp:forward page='a.jsp' /><br>
  <%} else if(move.equals("b.jsp")){ %>
 	 <jsp:forward page='a.jsp' /><br>
  <%} else{ %>
  <script>
  	window.alert("당신이 요청하신 페이지는 없습니다.\n다시 확인요망");
	location.href="forward.jsp";//history.back()
	
	  
  </script>
  <%} %>
</body>
</html>
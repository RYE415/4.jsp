<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body bgcolor="yellow">
  <h1>a.jsp로 오신 것을 환영합니다.</h1>
  <%
  	//request.setAttribute("total",su);->move2.jsp
  	//<-> request.getAttribute("total"(키명))
  	int su=(Integer)request.getAttribute("total");//형변환//Object->Integer-(자동언박싱)->int
  %>
  total의 값은?<%=su %>입니다.
  <hr><!-- 표현식으로 출력(자동 형변환이 된다.) -->
  move2.jsp에서 공유한 su의 값은?
  <%=request.getAttribute("total") %>
</body>
</html>
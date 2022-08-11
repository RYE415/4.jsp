<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>값 출력</title>
</head>
<body>
 <h1>값 출력</h1>
 <%
 request.setCharacterEncoding("utf-8");
 %>
 <%
  String name=request.getParameter("name");
 %>
 <b>이름은 <%=name %>입니다.</b><p>
 <b>이름은 <%=request.getParameter("name") %>입니다.</b><p>
 <b>이름은 (el) ${param.name }입니다.</b><p>
 
</body>
</html>
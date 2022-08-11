<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response(응답객체)</title>
</head>
<body>
  <%
  //response.setContentType("text/html; charset=UTF-8");
  //response.sendRedirect("http://www.daum.net");//외부 사이트 이동
  //response.sendRedirect("./req.jsp");//내부프로젝트의 특정 위치로 이동 가능
  
  %>
  <script>
  //location.href="http://www.naver.com";//객체명.속성명=값
  location.replace("http://www.empas.com");//객치명.함수명
  </script>
</body>
</html>
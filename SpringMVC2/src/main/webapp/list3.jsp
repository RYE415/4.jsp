<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청받아 처리해주는 페이지</title>
</head>
<body>
<h1>모델2와 동일:<%=request.getAttribute("greeting") %></h1><p>
<h1>환영합니다. ${greeting}</h1>
</body>
</html>
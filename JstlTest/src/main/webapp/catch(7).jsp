<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>catch(7).jsp</title>
</head>
<body>
<%
	//try{예외처리 가능문장}catch(Exception e){}
	//형식) <c:catch var="예외처리객체명">예외처리내용</c:catch>
%>
<h1>
  <c:catch var="ex">
  	name 매개변수:<%=request.getParameter("name") %>
  	<%
  		if(request.getParameter("name").equals("test")){%>
  			${param.name}은 test입니다.
  	<%}%>
  </c:catch>
  <c:if test="${ex!=null}">
  	예외가 발생하였습니다.<br>
  	${ex}
  </c:if>


</h1>
</body>
</html>
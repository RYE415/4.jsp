<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!-- 화면에 보여주기 전에 계산을 전부 처리해야 하기 때문에 여기에! -->
<jsp:useBean id="ca" class="calc.CalcBean" scope="page" />
<jsp:setProperty name="ca" property="*" />
<% ca.calculate(); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 하는 페이지(빈즈 이용)</title>
</head>
<body>
	<h3>계산기</h3>
	<!-- <form name="form1" method="post" action="cal2.jsp"> -->
	<!-- 2.action부분 생략하면 디폴트로 본인에게 요청,응답 -->
	<form name="form1" method="post">
		<input type="text" name="num1" width="200" size="5">
		<select name="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type="text" name="num2" width="200" size="5"><p>
		<input type="submit" value="계산">
		<input type="reset" value="다시입력">
		
	</form>
<hr>
계산결과:<%=ca.getResult() %>
</body>
</html>
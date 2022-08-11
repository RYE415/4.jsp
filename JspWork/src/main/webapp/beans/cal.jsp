<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 하는 페이지(빈즈 이용)</title>
</head>
<body>
	<h3>계산기</h3>
	<form name="form1" method="post" action="calResult.jsp">
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
</body>
</html>
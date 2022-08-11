<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="calc.CalcBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 받아서 처리해주는 페이지</title>
</head>
<body>
<%//방법 1: 순수 자바 방식
//자바빈즈=>클래스로 만들어서 메서드 호출목적(방법1)
	/* CalcBean ca=new CalcBean();
	ca.setNum1(Integer.parseInt(request.getParameter("num1")));
	ca.setOperator(request.getParameter("operator"));
	ca.setNum2(Integer.parseInt(request.getParameter("num2")));
	ca.calculate();//계산이 종료->result->getResult() 호출 */
%>
<!-- 방법 2:액션태그 방식 -->
<jsp:useBean id="ca" class="calc.CalcBean" scope="page" />
<jsp:setProperty name="ca" property="*" />
<% ca.calculate(); %>
<hr>
계산결과:<%=ca.getResult() %>
<hr>
계산결과2:<jsp:getProperty name="ca" property="result" />

</body>
</html>
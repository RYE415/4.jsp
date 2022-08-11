<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.BeanDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈와 액션태그의 조합</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//1. 메서드를 불러오기 위해서 객체를 생성
	//BeanDTO bd=new BeanDTO();
	//2.입력받은 갯수만큼 SetterMethod 호출
	//bd.setName(request.getParameter("name"));
	//bd.setAddr(request.getParameter("addr"));
	//System.out.println("입력받은 이름은=>"+bd.getName());
	//System.out.println("입력받은 주소는=>"+bd.getAddr());
%> 
<jsp:useBean id="bd" class="test.BeanDTO" scope="page" />
<%-- <jsp:setProperty name="bd" property="name" value="<%=name %>" />

<jsp:setProperty name="bd" property="addr" value="<%=addr %>" /> --%>

<jsp:setProperty name="bd" property="*" />

<p>
<hr>
액션태그를 통한 Getter Method를 호출하는 경우<p>
getName()호출=><jsp:getProperty name="bd" property="name" />
getAddr()호출=><jsp:getProperty name="bd" property="addr" />
<p>
<b><%=bd.getName() %></b>님 잘 오셨습니다!
<b>주소는 <%=bd.getAddr() %></b>이군요!
</body>
</html>
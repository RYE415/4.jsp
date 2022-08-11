<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chooseTag(5).jsp</title>
</head>
<body>
<%
//int age=20;
//String name="bk";
//if(age > 19) //<c:if test="${조건식}(el로 표시)"
%>
<c:set var="age" value="${20}" />
<c:set var="name" value="${'bk'}" />
<c:if test="true">
  무조건 실행이 되는 구문
</c:if><p>
<c:if test="${19 < age}">
  당신의 나이는 19살 이상이군요!!
</c:if><p>
  
 <c:if test="${name=='bk'}">
  name의 값은 ${name}입니다.<br>
</c:if>
<!-- c:if 액션태그에서는 else 구문이 없다. -->
<c:if test="${name!='bk'}">
  name의 값은 ${name}입니다.<br>
</c:if>
<!-- 액션태그는 %-- --% 이용해서 태그 달아야 함! 문자만 쓸 경우에는 !-- -- 로 써도 됨 -->
<!-- 
	다중if문 else if~ -> switch~case
	
	c:choose
	  c:when test="조건식1"  //c:choose안에는 if 못씀-> c:when으로 써야 함
	  	수행할 문장
	  /c:when
	  c:when test="조건식2"
	  	수행할 문장
	  /c:when
	  
	  ,,,
	  c:otherwise=>else 역할
	  	위의 조건에 해당되지 않은 경우
	  /c:otherwise
	/c:choose
 -->
<p>
<hr> <!--로그인한 값을 비교해서 특정 페이지로 이동 -->
<c:choose>
	<c:when test="${param.name2=='bk'}">
		<h1>name2의 파라미터값은 ${param.name2}입니다.</h1>
	</c:when>
	<c:when test="${param.age2 > 18}">
		<h1>당신의 나이는 18세 이상이군요!</h1>
	</c:when>
	<c:otherwise>
		<li>당신은 'bk'도 아니고 나이도 18세 이상이 아니군요.</li>
	</c:otherwise>

</c:choose>
</body>
</html>
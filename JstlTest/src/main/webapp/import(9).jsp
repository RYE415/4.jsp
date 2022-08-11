<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import(9).jsp(외부의 자원(페이지)를 가져오는 액션태그)</title>
</head>
<body>
<%
//접근금지(302 에러코드) 네이버, 다음,,, => http(X), https(O)
//<c:import url="접속사이트 주소" var="데이터를 저장할 변수명">
//escapeXml="true"(디폴트)=>태그 자체를 문자열로 인식=> 문자 형태로
//escapeXml="false" => html을 실행한 결과 그대로(본문대용 그대로)
%>
<c:set var="url" value="https://www.naver.com" />
<c:import url="${url}" var="u" />
<c:out value="${url}" />가져옵니다.<p>
<c:out value="${u}" escapeXml="false" />

<h4>내부자원을 가져오기</h4>
<!-- chooseTag(5).jsp?name2=bk -->
<c:set var="url" value="chooseTag(5).jsp" />
<c:import url="${url}" var="u">
	<c:param name="name2" value="bk" />
</c:import>

<c:out value="${u}" escapeXml="false" />
</body>
</html>
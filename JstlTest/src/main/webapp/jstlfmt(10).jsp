<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlfmt(10).jsp(날짜,시간,숫자 출력양식)</title>
</head>
<body>
<!-- 
	setLocale 액션태그-> value="언어-국가명" ko-KR,js-Jp,en-US
 -->
 <fmt:setLocale value="ko-KR" />
 <h1><!-- value(출력할 값),type(숫자,통화,퍼센트 단위를 지정) -->
 number:<fmt:formatNumber value="9876543.61" type="number" /><br>
 currency:<fmt:formatNumber value="9876543.61" type="currency" /><br>
 percent:<fmt:formatNumber type="percent">9876543.61</fmt:formatNumber><br>
 <!-- 사용자 정의 형식 포맷으로 지정 pattern="설정할 타입 포맷 지정" -->
 pattern:".0000": <fmt:formatNumber value="9876543.61" pattern=".0000" />
 pattern:"#,#00.0#": <fmt:formatNumber value="9876543.61" pattern="#,#00.0#" />
 
 <hr>
 <jsp:useBean id="now" class="java.util.Date" />
 <c:out value="${now}" /><p>
 <!-- 
 	formatDate value="출력할값" type(날짜만,시간만,둘다 출력)
  -->
 data:<fmt:formatDate value="${now}" type="date" /><br>
 time:<fmt:formatDate value="${now}" type="time" /><br>
 both:<fmt:formatDate value="${now}" type="both" /><br>
 <!-- 
 	dateStyle(날짜만 세부적으로 설정할 때),timeStyle(시간을 세부적으로 설정)	
  -->
 default:<fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default" /><br>
 short:<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
 medium:<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br>
 long:<fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br>
 full:<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
 
 pattern:"yy년 MM월 dd일 (HH시 mm분 ss초)"
 <fmt:formatDate value="${now}" type="both" pattern="yy년 MM월 dd일 (HH시 mm분 ss초)" /><br>
 <!-- 영국시간대(지역/도시명) -->
 <fmt:timeZone value="Europe/London">
 영국시간대:<fmt:formatDate value="${now}" type="both" pattern="yy년 MM월 dd일 (HH시 mm분 ss초)" /><br>
 </fmt:timeZone>
 <!-- 뉴욕시간대 -->
 <fmt:timeZone value="America/New_York">
 뉴욕시간대:<fmt:formatDate value="${now}" type="both" pattern="yy년 MM월 dd일 (HH시 mm분 ss초)" /><br>
 </fmt:timeZone>
 </h1>
</body>
</html>
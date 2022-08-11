<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	java.util.HashMap mapData=new java.util.HashMap();
	mapData.put("name","홍길동");//map객체명.get(키명)
	mapData.put("today",new java.util.Date());//날짜객체
	//int intArray[]={1,2,3,4,5};
%>
<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>" />
<!-- map도 같은 주소를 가진 동일한 객체(별칭) -->
<c:set var="map" value="<%=mapData %>" />
<html>
<head>
<meta charset="UTF-8">
<title>forEach(8).jsp</title>
</head>
<body>
  <%
  //1~100까지의 합 중에서 홀수값을 출력
  int sum=0;
  /* c:forEach var="초기변수명" begin="시작값" end="종료값" step="증가치"
		 											  (dafault step=1)이 아닌 경우는 생략X*/
  for(int i=1;i<=100;i+=2){
	  sum+=i;//sum=sum+i; 기존의 값에 새로운 값을 부여(=수정)
  }
  out.println(sum);
  %>
  <h4>1~100까지의 홀수값</h4>
  <c:set var="sum" value="0" /> <!-- 변수 선언 및 초기값 -->
  <c:forEach var="i" begin="1" end="100" step="2">
  	<c:set var="sum" value="${sum+i}" /> <!-- 수정의 의미 --> 
  </c:forEach>
  결과:${sum}
  <hr>
  <h4>배열의 값, 컬렉션 객체의 값을 출력</h4>
  <%--
  <c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>" />
  형식2) var="꺼낸 객체명" items="${출력할 내용이 들어가 있는 객체명}
   --%>
   <c:forEach var="i" items="${intArray}" begin="2" end="4">
   <h1>[${i}]</h1>
   </c:forEach>
   <c:forEach var="ab" items="${map}">
   	<h1>${ab.key}=${ab.value}</h1>
   </c:forEach>
   <hr>
   <%
   //문자열에서 구분되어서 분리되는 단어를 토콘(단어)
   String str2="JAVA,JSP,Spring,JQuery";
   //c:forTokens var="출력할 변수명(=객체명)" items="${출력객체명}" delims="구분기호"
   %>
   <%-- <c:set var="s" value="<%=str2%>" />
   <c:forTokens var="st" items="${s}" delims=","> --%>
   <c:forTokens var="st" items="고양이|강아지|호랑이|" delims="|">
   		<b>${st}&nbsp;</b>
   </c:forTokens>
</body>
</html>
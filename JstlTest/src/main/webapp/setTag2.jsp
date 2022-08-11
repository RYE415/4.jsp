<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%
  //java.util.HashMap map=new java.util.HashMap();
  //map.put("name", "홍길동");//map.get(키명(name))
  //=> <c:set target="map" property="name" value="홍길동" />
  //아래에 이걸로 변환!

%>
<html>
<head>
<meta charset="UTF-8">
<title>set태그의 두번째 예제</title>
</head>
<body>
<%--
  <c:set target="${불러올 객체명}" property="속성명(멤버변수명)" value="저장할값" />
 --%>
  <fmt:requestEncoding value="utf-8" />
  <c:set var="map" value="<%=new java.util.HashMap() %>" />
  <c:set target="${map}" property="name" value="홍길동" />
  <!-- map.get(키명) -->
  1.변수 map에 저장된 name 속성값:${map.name}<br> <!-- 1,2,3 다 같은 기능-> 1번 사용-> 누가 굳이 2,3 씀 -->
  2.변수 map에 저장된 name 속성값:${map['name']}<br>
  3.변수 map에 저장된 name 속성값:${map["name"]}<br>
  <p>
  <form method="post" action="setTag2.jsp">
  이름:<input type="text" name="name">
  	  <input type="submit" value="전송">
  </form>
  <hr>

 <%
  String name=request.getParameter("name");
 %>
 <b>이름은 <%=name %>입니다.</b><p>
 <b>이름은 <%=request.getParameter("name") %>입니다.</b><p>
 <b>이름은 (el) ${param.name }입니다.</b><p>
</body>
</html>
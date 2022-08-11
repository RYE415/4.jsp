<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지를 이동시키는 역할2</title>
</head>
<body>
  <h1>페이지 이동2</h1>
  <%
  //-------데이터를 공유할 값(서버의 메모리에 저장)
  
  int su=100; //a.jsp 가 공유해서 사용 가능? 일반적으로 no
  Date d=new Date();//오늘 날짜
  //서버의 메모리에 저장->객체만 저장->컬렉션=>HashMap(key,value)
  //형식) request|session|application.setAttribute("키명"저장할값)
  request.setAttribute("total",su);//int->Integer->Object
  request.setAttribute("cal",d);
  
  //---------------------------------------
  String move=request.getParameter("move");//a.jsp or b.jsp
  System.out.println("move=>"+move);//null or a.jsp
  //reponse.sendRedirect("a.jsp");//단순히 이동만 시킬 때 사용
  if(move.equals("a.jsp")){
  %>
  <!-- forward 액션태그명 page="이동할 페이지명"(데이터를 공유하면서 이동) -->
  	 <jsp:forward page='a.jsp' /><br>
  <%} else if(move.equals("b.jsp")){ %>
 	 <jsp:forward page='b.jsp' /><br>
  <%} else{ %>
  <script>
  	window.alert("당신이 요청하신 페이지는 없습니다.\n다시 확인요망");
	location.href="forward.jsp";//history.back()
	
	  
  </script>
  <%} %>
</body>
</html>
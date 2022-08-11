<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 확인</title>
</head>
<body>
<h1>웹브라우저에 저장된 쿠키를 가져오는 예제</h1>
<%
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			//쿠키이름 mycookies 찾았다면
			if(cookies[i].getName().equals("mycookie")){%>
			cookieName:<%=cookies[i].getName()%><br>
			cookieValue:<%=cookies[i].getValue()%><br>
			
		<% 
			}
		}
	}

%>
</body>
</html>
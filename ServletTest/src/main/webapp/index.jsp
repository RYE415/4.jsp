<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인창을 실행</title>
<script>
	function test(){//public void test(){}
		//1.경로 포함해서 불러올 문서명 2. 문서의 타이틀명 3. 창의 옵션
		//window.open('/sub/send.html','w','left=300,top=200,width=400,height=200');
		window.open('/Servlet/Notice','w','left=300,top=200,width=400,height=200');
	}
</script>
</head>
<body onload="alert('hello')">
	<h2>Welcome To JSP Study Site!!!</h2>

</body>
</html>
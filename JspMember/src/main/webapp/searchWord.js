/**
 * xhr객체를 생성->jsp로 요청->응답->콜백함수로 출력
 */
var xhrObject;//xhr객체(전역)

//1.xhr객체생성
function createXHR(){
	if(window.XMLHttpRequest){
		xhrObject=new XMLHttpRequest();//객체생성
		//alert(xhrObject);
	}
	}

//2.중복id체크->처리해주는 함수
function idCheck(id){
	if(id==""){//입력을 하지 않은 경우
		//var mem_id=document.getElementById("ducheck");
		var mem_id=$("ducheck");
		//alert(mem_id);
		$("ducheck").innerHTML="<font color='red'><b>아이디를 먼저 입력</b></font>";
		//document.regForm.mem_id.focus();
		$("mem_id").focus();
		return false;
	}
	//입력을 했을 경우 Ajax에 요청
	//1.xhr객체 생성
	createXHR()//xhrObject
	var url="http://localhost:8090/JspMember/IdCheck.jsp?"+getParameterValues()
	//alert(url);
	//2.콜백함수를 지정
	xhrObject.onreadystatechange=resultProcess;
	//3.open함수를 서버에 요청 준비
	xhrObject.open("Get",url,true);
	//4.send 호출
	xhrObject.send(null);
}

//3.파라미터값을 처리해주는 함수(서버의 메모리 제거)
function getParameterValues(){
	var mem_id=$("mem_id").value;
	//서버캐시에 요청->메모리에 저장하지 않는 방법
	//파라미터값을 하나 전달할 때 오늘 날짜를 같이 출력시켜주는 매개변수를 첨부
	return "mem_id="+mem_id+"&timestamp="+new Date().getTime()
}

//4.콜백함수
function resultProcess(){
	//alert("resultProcess");
	if(xhrObject.readyState==4){//서버가 요청을 다 받았다면
		if(xhrObject.status==200){//서버의 결과를 다 보내줬다면
			var result=xhrObject.responseText;//태그+문자열=>문자열
			$("ducheck").innerHTML=result;
		}
	}
}
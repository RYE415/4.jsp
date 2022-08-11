/**
 *  기능:회원가입 처리 중 jQuery
	작성자:홍길동
	작성날짜:2022.08.03
 */
$(function(){
	//에러메세지는 처음에는 안보이게 설정(show()<->hide())
	$('#id_error').hide();
	$('#age_error1').hide();
	$('#age_error2').hide();
	$('#p_error1').hide();
	$('#p_error2').hide();
	//<input type="button" id="btnSend" value="전송">
	$('#btnSend').click(function(){
	//입력을 했다는 코드
	//1.id입력체크
	var id=$('#userid').val();
	
	if(id.length < 1){
		$('#id_error').show();
		return false;
	}else{//한글자라도 입력
		$('#id_error').hide();	
	}
	
	//2.age입력체그
	var age=$('#age').val();
	
	if(age.length < 1){
		$('#age_error1').show();
		return false;
	}else{//한글자라도 입력
		$('#age_error1').hide();	
	}
	
	//3.숫자인지 체크->2a or a2,23a,,,
	//0(48)~9(57)범위를 벗어나면 무조건 문자=>String->charAt(번호)
	//isNaN함수를 이용
	for(var i=0;i<age.length;i++){
	//charCodeAt(0)=>아스키코드로 변환하는 함수
		var data=age.charAt(i).charCodeAt(0);	
		//alert(data);
		if(data < 48 || data > 57){//문자입력한 경우
			$('#age_error2').show();
			return false;
			break;//더이상 진행할 필요X
			}else{//숫자입력
			$('#age_error2').hide();
		}
	}
	
	//4.pwd입력
	var pwd1=$('#pwd1').val();
	
	if(pwd1.length < 1){
		$('#p_error1').show();
		$('#pwd1').next().show();
		return false;
	}else{//한글자라도 입력
		$('#p_error1').hide();	
	}
	//5.pwd불일치 체크
		var pwd2=$('#pwd2').val();
	
	if(pwd2.length < 1){
		$('#p_error2').show();
		return false;
	}else{//한글자라도 입력
		$('#p_error2').hide();	
	}
	//불일치
	if(pwd1!=pwd2){
		$('#p_error2').show();
	}
	//다 입력했다면 document.form객체명.submit()->action=register.jsp
	 $('#signup').attr('action','register.jsp').submit();
	 return true;//전송이 가능하게 설정
	})
})
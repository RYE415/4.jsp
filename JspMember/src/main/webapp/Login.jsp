<%@page contentType="text/html;charset=euc-kr"%>
<%
//���󿡼� �α����ߴ��� ���ߴ��� Ȯ��
//session.setAttribute("idKey",mem_id);->LoginProc.jsp
String mem_id=(String)session.getAttribute("idKey");
System.out.println("LoginSuccess.jsp�� mem_id"+mem_id);
%>

<HTML>
 <HEAD>
  <TITLE> �α��� </TITLE>
<link href="style.css" rel="stylesheet"
      type="text/css">
<SCRIPT LANGUAGE="JavaScript" src="script.js">
</SCRIPT>
 </HEAD>

 <BODY onload="document.login.mem_id.focus()" bgcolor="#FFFFCC">
  <center>
  <!-- mem_id�� ���¿����� �α��� ó�� -->
  <br><br><br>
 <%
if(mem_id!=null){//������ ����̶��
%>
<b><%=mem_id %></b>�� ȯ���մϴ�.<p>
����� ���ѵ� ����� ����� ���� �ֽ��ϴ�.<p>
<a href="MemberUpdate.jsp">ȸ������</a>
<a href="DelCheckForm.jsp?mem_id=<%=mem_id %>">ȸ��Ż��</a>
<a href="Logout.jsp">�α׾ƿ�</a>
<%}else{ %>

  <!-- �α��� �ȵ� ���� -->
     <TABLE>
    <form name="login" method="post" 
	                   action="LoginProc.jsp">
     <TR>
		<TD align="center" colspan="2">
		<h4>�α���</h4></TD>
     </TR>

     <TR>
		<TD>���̵�</TD>
		<TD><INPUT TYPE="text" NAME="mem_id"></TD>
     </TR>
     <TR>
		<TD>��й�ȣ</TD>
		<TD><INPUT TYPE="password" NAME="mem_passwd"></TD>
     </TR>
     <TR>
		<TD colspan="2"><div align="center">
		<INPUT TYPE="button" value="�α���" onclick="loginCheck()">&nbsp;
		<INPUT TYPE="button" value="ȸ������"
		onclick="memberReg()">
		</div>
		</TD>
     </TR>
	 </form>
     </TABLE>
     <%} %>
 
  </center>
 </BODY>
</HTML>

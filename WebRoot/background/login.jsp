<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>��½����-����ͼ���̳Ǻ�̨����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#BDE7FD" text="#000000">
		<table width="500">
			<tr>
				<td width="50">&nbsp;<img src="images/ht01.jpg" width="80" height="80"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="R#BDE7FD">
			<tr>
				<td class="wr2">
					<div align="center" class="divcss5" style=" font-size:36px;">
						����ͼ���̳Ǻ�̨��¼
					</div>
				</td>
			</tr>
		</table>
		<br/>
		<br/>
		<form action="${pageContext.request.contextPath}/BackgroundLoginServlet" method="post">
		<table width="100%" bgcolor="#BDE7FD">
				<tr>
				<td class="wr2">
					<div align="center">
					<font color="blue"><b>�û���</b></font> : <input type="text" name="name"/><br><br>
					<font color="blue"><b>��&nbsp;��</b></font>  : <input type="password" name="pwd"/><br><br>
					<input type="submit" style="width:80px;height:26px;" value="��½" /> <br><br>
					</div>    
				</tr>
		</table>
		</form>
		<p align="center">
		</p>
	</body>
</html>

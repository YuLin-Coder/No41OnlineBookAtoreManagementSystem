<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>登陆界面-网上图书商城后台管理系统</title>
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
						网上图书商城后台登录
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
					<font color="blue"><b>用户名</b></font> : <input type="text" name="name"/><br><br>
					<font color="blue"><b>密&nbsp;码</b></font>  : <input type="password" name="pwd"/><br><br>
					<input type="submit" style="width:80px;height:26px;" value="登陆" /> <br><br>
					</div>    
				</tr>
		</table>
		</form>
		<p align="center">
		</p>
	</body>
</html>

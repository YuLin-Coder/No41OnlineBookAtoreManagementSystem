<%@page import="com.bookstore.bean.SysAdmin"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@include file="checkLogin.jsp" %>
<html>
<head>
<style>
<!--
.wr {
	font-size: 12pt;
	line-height: 22px
}

.wr1 {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 200%
}

.wr2 {
	FONT-SIZE: 14px;
	LINE-HEIGHT: 200%
}

.wr3 {
	FONT-SIZE: 12px
}

.wr4 {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 150%
}
//
-->
</style>
<title>网上图书商城后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFDB" text="#000000" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0">
	<%
		SysAdmin sysAdmin = (SysAdmin)session.getAttribute("sysAdmin");
	%>
	<table width="160" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>&nbsp;</td>
			<td width="12">&nbsp;</td>
		</tr>
		<tr>
			<td align="center">欢迎您：<%=sysAdmin.getAdminName()%></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td width="12">&nbsp;</td>
		</tr>
		
		<%if(sysAdmin.getAdminType() == 3) {%>
			<%@include file="adminLeft.jsp"%>				
		<%} else if(sysAdmin.getAdminType() == 2) {%>
			<%@include file="guestLeft.jsp"%>
		<%} else if(sysAdmin.getAdminType() == 1) {%>
			<%@include file="userLeft.jsp"%>
		<%}%>		
		
		<tr>
			<td class="wr4">&nbsp;</td>
			<td width="12">&nbsp;</td>
		</tr>
		<tr>
			<td background="images/ht08.jpg" class="wr4">
				<div align="center">
				<a href="<%=request.getContextPath()%>/BackgroundLoginOutServlet" target="_parent">退 出 系 统</a>
				</div></td>
			<td width="12"><img src="images/ht07.jpg" width="12" height="20">
			</td>
		</tr>
	</table>
</body>
</html>
<script></script>


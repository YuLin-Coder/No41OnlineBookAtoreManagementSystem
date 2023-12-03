<%@page import="com.bookstore.bean.CustomerInfo"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户基本信息</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
    <%
    	CustomerInfo info = (CustomerInfo)request.getAttribute("info");
     %>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/UpdateCustomerInfoServlet" method="post">
  		<table align="center">
  			<caption>修改用户基本信息</caption>
  			<tr>
  				<td>用户编号：</td>
  				<td><input type="text" name="custId" value="<%=info.getCustId()%>" readonly></td>
  			</tr>
  			<tr>
  				<td>用户名称：</td>
  				<td><input type="text" name="custName" value="<%=info.getCustName()%>"></td>
  			</tr>
  			<tr>
  				<td>用户密码：</td>
  				<td><input type="text" name="pwd" value="<%=info.getPwd()%>"></td>
  			</tr>
  			<tr>
  				<td>用户邮箱：</td>
  				<td><input type="text" name="email" value="<%=info.getEmail()%>"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"></td>
  				<td><input type="reset" value="reset"></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增管理员</title>
    <style type="text/css">
		@import '${pageContext.request.contextPath}/background/css/addUpdate.css'
	</style>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/SaveAdminServlet" method="post">
  		<table align="center">
  			<caption>新增管理员信息</caption>
  			<tr>
  				<td>管理员姓名：</td>
  				<td><input type="text" name="adminName"></td>
  			</tr>
  			<tr>
  				<td>管理员密码：</td>
  				<td><input type="text" name="pwd"></td>
  			</tr>
  			<tr>
  				<td>管理员类别：</td>
  				<td><input type="text" name="adminType"></td>
  			</tr>
  			<tr>
     		<td><input type="submit" value="submit"/></td>
     		<td><input type="reset" value="reset"/></td>
     		</tr>
  		</table>
  	</form>
  </body>
</html>

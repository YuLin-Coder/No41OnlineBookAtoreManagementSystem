<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增员工</title>
	<style type="text/css">
		@import '${pageContext.request.contextPath}}/background/css/addUpdate.css'
	</style>
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/SaveEmployeeServlet" method = "post">
  	<table align = "center">
  		<caption>新增员工信息</caption>
  		<!-- <tr>
  			<td>员工编号：</td>
  			<td><input type = "text" name = "empId" readonly></td>
  		</tr> -->
  		<tr>
  			<td>员工姓名：</td>
  			<td><input type = "text" name = "empName"></td>
  		</tr>
  		<tr>
  			<td>员工年龄：</td>
  			<td><input type = "text" name = "empAge"></td>
  		</tr>
  		<tr>
  			<td>员工生日：</td>
  			<td><input type = "text" name = "empBtd"></td>
  		</tr>
  		<tr>
  			<td>员工性别：</td>
  			<td><input type = "text" name = "empSex"></td>
  		</tr>
  		<tr>
     		<td><input type="submit" value="submit"/></td>
     		<td><input type="reset" value="reset"/></td>
     	</tr>
  	</table>
  </form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸Ĺ���Ա��Ϣ</title>
	<style type="text/css">
    	@import '${pageContext.request.contextPath}/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/UpdateAdminServlet" method="post">
  		<table align="center">
  			<caption>�޸Ĺ���Ա��Ϣ</caption>
  			<tr>
  				<td>����Ա��ţ�</td>
  				<td><input type="text" name="adminId" value="${requestScope.admin.adminId}" readonly></td>
  			</tr>
  			<tr>
  				<td>����Ա������</td>
  				<td><input type="text" name="adminName" value="${requestScope.admin.adminName}"></td>
  			</tr>
  			<tr>
  				<td>����Ա���룺</td>
  				<td><input type="text" name="pwd" value="${requestScope.admin.pwd}"></td>
  			</tr>
  			<tr>
  				<td>����Ա���</td>
  				<td><input type="text" name="adminType" value="${requestScope.admin.adminType}"></td>
  			</tr>
  			<tr>
     		<td><input type="submit" value="submit"/></td>
     		<td><input type="reset" value="reset"/></td>
     		</tr>
  		</table>
  	</form>
  </body>
</html>

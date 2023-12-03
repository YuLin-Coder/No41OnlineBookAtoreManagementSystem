<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'saveCusDetailInfo.jsp' starting page</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
	</style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveDetailInfoServlet" method="post">
  		<table align="center">
  			<caption>新增用户详细信息</caption>
  			<tr>
  				<td>用户联系电话：</td>
  				<td><input type="text" name="tel"></td>
  			</tr>
  			<tr>
  				<td>用户地址：</td>
  				<td><input type="text" name="address"></td>
  			</tr>
  			<tr>
  				<td>用户性别：</td>
  				<td><input type="text" name="sex"></td>
  			</tr>
  			<tr>
  				<td>用户年龄：</td>
  				<td><input type="text" name="age"></td>
  			</tr>
  			<tr>
  				<td>用户累计消费金额：</td>
  				<td><input type="text" name="countMoney"></td>
  			</tr>
  			<tr>
  				<td>用户qq号码：</td>
  				<td><input type="text" name="qq"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

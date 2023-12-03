<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增书评信息</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveBookDiscussServlet" method="post">
  		<table align="center">
  			<tr>
  				<td>图书编号：</td>
  				<td><input type="text" name="bookId"></td>
  			</tr>
  			<tr>
  				<td>用户编号：</td>
  				<td><input type="text" name="custId"></td>
  			</tr>
  			<tr>
  				<td>书评内容：</td>
  				<td><input type="text" name="context"></td>
  			</tr>
  			<tr>
  				<td>书评状态：</td>
  				<td><input type="text" name="states"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

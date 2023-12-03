<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增图书类别</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveBookTypeServlet" method="post">
  		<table align="center">
  			<caption>新增图书类别</caption>
  			<tr>
  				<td>新增父编号：</td>
				<td><input type="text" name="parentId"></td>
  			</tr>
  			<tr>
  				<td>新增图书类别名称：</td>
  				<td><input type="text" name="bookTypeName"></td>
  			</tr>
  			<tr>
  				<td>新增备注：</td>
  				<td><input type="text" name="context"></td>
  			</tr>
  			<tr>
  				<td>是否可用：</td>
  				<td><input type="text" name="isDelete"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

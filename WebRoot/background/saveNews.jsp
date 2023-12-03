<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新闻</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveNewsServlet" method="post">
  		<table align="center">
  			<caption>新增新闻</caption>
  			<!-- <tr>
  				<td>新闻编号：</td>
  				<td><input type="text" name="newsId"></td>
  			</tr> -->
  			<tr>
  				<td>新闻标题：</td>
  				<td><input type="text" name="newTitle"></td>
  			</tr>
  			<tr>
  				<td>新闻发布内容：</td>
  				<td><input type="text" name="context"></td>
  			</tr>
  			<tr>
  				<td>新闻发布时间：</td>
  				<td><input type="text" name="createTime"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
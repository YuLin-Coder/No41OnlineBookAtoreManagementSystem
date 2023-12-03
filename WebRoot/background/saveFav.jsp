<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新增收藏夹信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
	</style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveFavServlet" method="post">
  		<table align="center">
  			<caption>新增收藏夹信息</caption>
    		<tr>
    			<td>图书编号：</td>
    			<td><input type="text" name="bookId"></td>
    		</tr>
    		<tr>
    			<td>用户编号：</td>
    			<td><input type="text" name="custId"></td>
    		</tr>
    		<tr>
    			<td>收藏时间：</td>
    			<td><input type="text" name="date"></td>
    		</tr>
    		<tr>
    			<td>备注：</td>
    			<td><input type="text" name="context"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit"/></td>
    			<td><input type="reset" value="reset"/></td>
    		</tr>
  		</table>
  	</form>
  </body>
</html>

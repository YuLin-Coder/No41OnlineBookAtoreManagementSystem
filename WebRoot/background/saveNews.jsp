<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�������</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveNewsServlet" method="post">
  		<table align="center">
  			<caption>��������</caption>
  			<!-- <tr>
  				<td>���ű�ţ�</td>
  				<td><input type="text" name="newsId"></td>
  			</tr> -->
  			<tr>
  				<td>���ű��⣺</td>
  				<td><input type="text" name="newTitle"></td>
  			</tr>
  			<tr>
  				<td>���ŷ������ݣ�</td>
  				<td><input type="text" name="context"></td>
  			</tr>
  			<tr>
  				<td>���ŷ���ʱ�䣺</td>
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
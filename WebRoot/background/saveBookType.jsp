<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����ͼ�����</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveBookTypeServlet" method="post">
  		<table align="center">
  			<caption>����ͼ�����</caption>
  			<tr>
  				<td>��������ţ�</td>
				<td><input type="text" name="parentId"></td>
  			</tr>
  			<tr>
  				<td>����ͼ��������ƣ�</td>
  				<td><input type="text" name="bookTypeName"></td>
  			</tr>
  			<tr>
  				<td>������ע��</td>
  				<td><input type="text" name="context"></td>
  			</tr>
  			<tr>
  				<td>�Ƿ���ã�</td>
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

<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�����û�������Ϣ</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>

  </head>
  <body>
  	<form action="<%=request.getContextPath()%>/SaveCustomerInfoServlet" method="post">
  		<table align="center">
  			<caption>�����û�������Ϣ</caption>
  			<tr>
  				<td>�û����ƣ�</td>
  				<td><input type="text" name="custName"></td>
  			</tr>
  			<tr>
  				<td>�û����룺</td>
  				<td><input type="text" name="pwd"></td>
  			</tr>
  			<tr>
  				<td>�û����䣺</td>
  				<td><input type="text" name="email"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"></td>
  				<td><input type="reset" value="reset"></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

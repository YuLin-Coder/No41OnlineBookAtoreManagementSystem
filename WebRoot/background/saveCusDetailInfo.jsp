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
  			<caption>�����û���ϸ��Ϣ</caption>
  			<tr>
  				<td>�û���ϵ�绰��</td>
  				<td><input type="text" name="tel"></td>
  			</tr>
  			<tr>
  				<td>�û���ַ��</td>
  				<td><input type="text" name="address"></td>
  			</tr>
  			<tr>
  				<td>�û��Ա�</td>
  				<td><input type="text" name="sex"></td>
  			</tr>
  			<tr>
  				<td>�û����䣺</td>
  				<td><input type="text" name="age"></td>
  			</tr>
  			<tr>
  				<td>�û��ۼ����ѽ�</td>
  				<td><input type="text" name="countMoney"></td>
  			</tr>
  			<tr>
  				<td>�û�qq���룺</td>
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

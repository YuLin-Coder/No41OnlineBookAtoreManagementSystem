<%@page import="com.bookstore.bean.CustomerDetailInfo"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸��û���ϸ��Ϣ</title>
	<%
		CustomerDetailInfo info = (CustomerDetailInfo)request.getAttribute("info");
	 %>
  </head>
  <body>
  	<form action="<%=request.getContextPath()%>/UpdateDetailInfoServlet" method="post">
  		<table align="center">
  			<caption>�޸��û���ϸ��Ϣ</caption>
  			<tr>
  				<td>�û���ţ�</td>
  				<td><input type="text" name="custId" value="<%=info.getCustId()%>" 
  					readonly></td>
  			</tr>
  			<tr>
  				<td>�û���ϵ�绰��</td>
  				<td><input type="text" name="tel" value="<%=info.getTel()%>"></td>
  			</tr>
  			<tr>
  				<td>�û���ַ��</td>
  				<td><input type="text" name="address" value="<%=info.getAddress()%>"></td>
  			</tr>
  			<tr>
  				<td>�û��Ա�</td>
  				<td><input type="text" name="sex" value="<%=info.getSex()%>"></td>
  			</tr>
  			<tr>
  				<td>�û����䣺</td>
  				<td><input type="text" name="age" value="<%=info.getAge()%>"></td>
  			</tr>
  			<tr>
  				<td>�û��ۼ����ѽ�</td>
  				<td><input type="text" name="countMoney" value="<%=info.getCountMoney()%>"></td>
  			</tr>
  			<tr>
  				<td>�û�qq���룺</td>
  				<td><input type="text" name="qq" value="<%=info.getQq()%>"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

<%@page import="com.bookstore.bean.CustomerDetailInfo"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户详细信息</title>
	<%
		CustomerDetailInfo info = (CustomerDetailInfo)request.getAttribute("info");
	 %>
  </head>
  <body>
  	<form action="<%=request.getContextPath()%>/UpdateDetailInfoServlet" method="post">
  		<table align="center">
  			<caption>修改用户详细信息</caption>
  			<tr>
  				<td>用户编号：</td>
  				<td><input type="text" name="custId" value="<%=info.getCustId()%>" 
  					readonly></td>
  			</tr>
  			<tr>
  				<td>用户联系电话：</td>
  				<td><input type="text" name="tel" value="<%=info.getTel()%>"></td>
  			</tr>
  			<tr>
  				<td>用户地址：</td>
  				<td><input type="text" name="address" value="<%=info.getAddress()%>"></td>
  			</tr>
  			<tr>
  				<td>用户性别：</td>
  				<td><input type="text" name="sex" value="<%=info.getSex()%>"></td>
  			</tr>
  			<tr>
  				<td>用户年龄：</td>
  				<td><input type="text" name="age" value="<%=info.getAge()%>"></td>
  			</tr>
  			<tr>
  				<td>用户累计消费金额：</td>
  				<td><input type="text" name="countMoney" value="<%=info.getCountMoney()%>"></td>
  			</tr>
  			<tr>
  				<td>用户qq号码：</td>
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

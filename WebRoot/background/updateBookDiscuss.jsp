<%@page import="com.bookstore.bean.BookDiscuss"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改书评信息</title>
    <style type="text/css">
		@import '<%= request.getContextPath() %>/background/css/addUpdate.css'
	</style>
	<%
		BookDiscuss discuss = (BookDiscuss)request.getAttribute("discuss");
	 %>
  </head>
  
  <body>
  	 <form action="<%= request.getContextPath() %>/UpdateBookDiscussServlet" method="post">
     	<table align="center">
     		<tr>
  				<td>书评编号：</td>
  				<td><input type="text" name="disId" value="<%=discuss.getDisId()%>"
  					readonly></td>
  			</tr>
     		<tr>
  				<td>图书编号：</td>
  				<td><input type="text" name="bookId" value="<%=discuss.getBookId()%>"></td>
  			</tr>
  			<tr>
  				<td>用户编号：</td>
  				<td><input type="text" name="custId" value="<%=discuss.getCustId()%>"></td>
  			</tr>
  			<tr>
  				<td>书评内容：</td>
  				<td><input type="text" name="context" value="<%=discuss.getContext()%>"></td>
  			</tr>
  			<tr>
  				<td>书评状态：</td>
  				<td><input type="text" name="states" value="<%=discuss.getStates()%>"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="submit"/></td>
  				<td><input type="reset" value="reset"/></td>
  			</tr>
     	</table>
     </form>
  </body>
</html>

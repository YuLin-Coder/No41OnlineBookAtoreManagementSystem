<%@page import="com.bookstore.bean.BookType"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改图书类别信息</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  <%
  	BookType bookType = (BookType)request.getAttribute("bookType");
   %>
   	<form action="<%=request.getContextPath()%>/UpdateBookTypeServlet" method="post">
   		<table align="center">
   			<caption>修改图书类别信息</caption>
   			<tr>
   				<td>修改图书类别信息：</td>
   				<td><input type="text" name="bookTypeId" value="<%=bookType.getBookTypeId()%>"
   					readonly></td>
   			</tr>
   			<tr>
   				<td>修改父编号：</td>
   				<td><input type="text" name="parentId" value="<%=bookType.getParentId()%>"></td>
   			</tr>
   			<tr>
   				<td>修改图书类别名称：</td>
   				<td><input type="text" name="bookTypeName" value="<%=bookType.getBookTypeName()%>"></td>
   			</tr>
   			<tr>
   				<td>修改备注：</td>
   				<td><input type="text" name="context" value="<%=bookType.getContext()%>"></td>
   			</tr>
   			<tr>
   				<td>修改是否可用：</td>
   				<td><input type="text" name="isDelete" value="<%=bookType.getIsDelete()%>"></td>
   			</tr>
   			<tr>
   				<td><input type="submit" value="submit"/></td>
   				<td><input type="reset" value="reset"/></td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>

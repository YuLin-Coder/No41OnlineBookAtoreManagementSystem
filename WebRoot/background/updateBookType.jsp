<%@page import="com.bookstore.bean.BookType"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸�ͼ�������Ϣ</title>
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
   			<caption>�޸�ͼ�������Ϣ</caption>
   			<tr>
   				<td>�޸�ͼ�������Ϣ��</td>
   				<td><input type="text" name="bookTypeId" value="<%=bookType.getBookTypeId()%>"
   					readonly></td>
   			</tr>
   			<tr>
   				<td>�޸ĸ���ţ�</td>
   				<td><input type="text" name="parentId" value="<%=bookType.getParentId()%>"></td>
   			</tr>
   			<tr>
   				<td>�޸�ͼ��������ƣ�</td>
   				<td><input type="text" name="bookTypeName" value="<%=bookType.getBookTypeName()%>"></td>
   			</tr>
   			<tr>
   				<td>�޸ı�ע��</td>
   				<td><input type="text" name="context" value="<%=bookType.getContext()%>"></td>
   			</tr>
   			<tr>
   				<td>�޸��Ƿ���ã�</td>
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

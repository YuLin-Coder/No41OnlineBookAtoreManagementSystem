<%@page import="com.bookstore.bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸�������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
  </head>
  
  <body>
  	<%
  		News news = (News)request.getAttribute("news");
  	 %>
  	 <form action="<%=request.getContextPath()%>/UpdateNewsServlet" method="post">
  	 	<table align="center">
  	 		<caption>�޸�������Ϣ</caption>
  	 		<tr>
  	 			<td>���ű�ţ�</td>
  	 			<td><input type="text" name="newsId" value="<%=news.getNewsId() %>"
  	 				readonly></td>
  	 		</tr>
  	 		<tr>
  	 			<td>���ű��⣺</td>
  	 			<td><input type="text" name="newTitle" value="<%=news.getNewTitle()%>"></td>
  	 		</tr>
  	 		<tr>
  	 			<td>�������ݣ�</td>
  	 			<td><input type="text" name="context" value="<%=news.getContext()%>"></td>
  	 		</tr>
  	 		<tr>
  	 			<td>���ŷ���ʱ�䣺</td>
  	 			<td><input type="text" name="createTime" value="<%=news.getCreateTime()%>"></td>
  	 		</tr>
  	 		<tr>
  	 			<td><input type="submit" value="submit"/></td>
  	 			<td><input type="reset" value="reset"/></td>
  	 		</tr>
  	 	</table>
  	 </form>
  </body>
</html>


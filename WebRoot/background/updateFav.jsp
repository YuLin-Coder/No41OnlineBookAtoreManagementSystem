<%@page import="com.bookstore.bean.Favorite"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸��ղؼ���Ϣ</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	 <%
    	Favorite favorite = (Favorite)request.getAttribute("favorite");
     %>
    <form action="<%=request.getContextPath()%>/UpdateFavServlet" method="post">
    	<table align="center">
    		<caption>�޸��ղؼ���Ϣ</caption>
    		<tr>
    			<td>�ղؼб�ţ�</td>
    			<td><input type="text" name="favoriteId" value="<%=favorite.getFavoriteId() %>" readonly></td>
    		</tr>
    		<tr>
    			<td>ͼ���ţ�</td>
    			<td><input type="text" name="bookId" value="<%=favorite.getBookId()%>"></td>
    		</tr>
    		<tr>
    			<td>�û���ţ�</td>
    			<td><input type="text" name="custId" value="<%=favorite.getCustId()%>"></td>
    		</tr>
    		<tr>
    			<td>�ղ�ʱ�䣺</td>
    			<td><input type="text" name="date" value="<%=favorite.getScdate()%>"></td>
    		</tr>
    		<tr>
    			<td>��ע��</td>
    			<td><input type="text" name="context" value="<%=favorite.getContext()%>"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit"/></td>
    			<td><input type="reset" value="reset"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

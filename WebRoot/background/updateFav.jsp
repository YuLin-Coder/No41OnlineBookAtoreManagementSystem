<%@page import="com.bookstore.bean.Favorite"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改收藏夹信息</title>
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
    		<caption>修改收藏夹信息</caption>
    		<tr>
    			<td>收藏夹编号：</td>
    			<td><input type="text" name="favoriteId" value="<%=favorite.getFavoriteId() %>" readonly></td>
    		</tr>
    		<tr>
    			<td>图书编号：</td>
    			<td><input type="text" name="bookId" value="<%=favorite.getBookId()%>"></td>
    		</tr>
    		<tr>
    			<td>用户编号：</td>
    			<td><input type="text" name="custId" value="<%=favorite.getCustId()%>"></td>
    		</tr>
    		<tr>
    			<td>收藏时间：</td>
    			<td><input type="text" name="date" value="<%=favorite.getScdate()%>"></td>
    		</tr>
    		<tr>
    			<td>备注：</td>
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

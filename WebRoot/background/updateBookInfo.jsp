<%@page import="com.bookstore.bean.BookInfo"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改图书基本信息</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
    <%
    	BookInfo info = (BookInfo)request.getAttribute("bookInfo");
     %>

  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/UpdateBookInfoServlet" method="post">
  		<table align="center">
  			<caption>修改图书基本信息</caption>
  			<tr>
  				<td>图书编号：</td>
  				<td><input type="text" name="bookId" value="<%=info.getBookId() %>" readonly></td>
  			</tr>
  			<tr>
  				<td>图书名称：</td>
  				<td><input type="text" name="bookName" value="<%=info.getBookName() %>"></td>
  			</tr>
  			<tr>
  				<td>图书类别编号：</td>
  				<td><input type="text" name="bookTypeId" value="<%=info.getBooktypeId()%>"></td>
  			</tr>
  			<tr>
  				<td>作者：</td>
  				<td><input type="text" name="author" value="<%=info.getAuthor() %>"></td>
  			</tr>
  			<tr>
  				<td>出版社名称：</td>
  				<td><input type="text" name="pbName" value="<%=info.getPbName() %>"></td>
  			</tr>
  			<tr>
  				<td>图书介绍：</td>
  				<td><input type="text" name="context" value="<%=info.getContext() %>"></td> 
  			</tr>
  			<tr>
  				<td>图书小图片：</td>
  				<td><input type="text" name="smallImg" value="<%=info.getSmallImg() %>"></td>
  			</tr>
  			<tr>
  				<td>图书大图片：</td>
  				<td><input type="text" name="bigImg" value="<%=info.getBigImg() %>"></td>
  			</tr>
  			<tr>
  				<td>价格：</td>
  				<td><input type="text" name="price" value="<%=info.getPrice() %>"></td>
  			</tr>
  			<tr>
  				<td>出版日期：</td>
  				<td><input type="text" name="pbdate" value="<%=info.getPbdate() %>"></td>
  			</tr>
  			<tr>
  				<td>会员价：</td>
  				<td><input type="text" name="hyprice" value="<%=info.getHyprice() %>"></td>
  			</tr>
  			<tr>
  				<td>图书状态：</td>
  				<td><input type="text" name="bookStates" value="<%=info.getBookStates() %>"></td>
  			</tr>
  			<tr>
  				<td>上架时间：</td>
  				<td><input type="text" name="sjdate" value="<%=info.getSjdate() %>"></td>
  			</tr>
  			<tr>
  				<td>库存量：</td>
  				<td><input type="text" name="num" value="<%=info.getNum() %>"></td>
  			</tr>
  			<tr>
  				<td>累积销售量：</td>
  				<td><input type="text" name="saleCount" value="<%=info.getSaleCount() %>"></td>
  			</tr>
  			<tr>
     		<td><input type="submit" value="submit"/></td>
     		<td><input type="reset" value="reset"/></td>
     	</tr>
  		</table>
  	</form>
  </body>
</html>

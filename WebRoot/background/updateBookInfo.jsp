<%@page import="com.bookstore.bean.BookInfo"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸�ͼ�������Ϣ</title>
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
  			<caption>�޸�ͼ�������Ϣ</caption>
  			<tr>
  				<td>ͼ���ţ�</td>
  				<td><input type="text" name="bookId" value="<%=info.getBookId() %>" readonly></td>
  			</tr>
  			<tr>
  				<td>ͼ�����ƣ�</td>
  				<td><input type="text" name="bookName" value="<%=info.getBookName() %>"></td>
  			</tr>
  			<tr>
  				<td>ͼ������ţ�</td>
  				<td><input type="text" name="bookTypeId" value="<%=info.getBooktypeId()%>"></td>
  			</tr>
  			<tr>
  				<td>���ߣ�</td>
  				<td><input type="text" name="author" value="<%=info.getAuthor() %>"></td>
  			</tr>
  			<tr>
  				<td>���������ƣ�</td>
  				<td><input type="text" name="pbName" value="<%=info.getPbName() %>"></td>
  			</tr>
  			<tr>
  				<td>ͼ����ܣ�</td>
  				<td><input type="text" name="context" value="<%=info.getContext() %>"></td> 
  			</tr>
  			<tr>
  				<td>ͼ��СͼƬ��</td>
  				<td><input type="text" name="smallImg" value="<%=info.getSmallImg() %>"></td>
  			</tr>
  			<tr>
  				<td>ͼ���ͼƬ��</td>
  				<td><input type="text" name="bigImg" value="<%=info.getBigImg() %>"></td>
  			</tr>
  			<tr>
  				<td>�۸�</td>
  				<td><input type="text" name="price" value="<%=info.getPrice() %>"></td>
  			</tr>
  			<tr>
  				<td>�������ڣ�</td>
  				<td><input type="text" name="pbdate" value="<%=info.getPbdate() %>"></td>
  			</tr>
  			<tr>
  				<td>��Ա�ۣ�</td>
  				<td><input type="text" name="hyprice" value="<%=info.getHyprice() %>"></td>
  			</tr>
  			<tr>
  				<td>ͼ��״̬��</td>
  				<td><input type="text" name="bookStates" value="<%=info.getBookStates() %>"></td>
  			</tr>
  			<tr>
  				<td>�ϼ�ʱ�䣺</td>
  				<td><input type="text" name="sjdate" value="<%=info.getSjdate() %>"></td>
  			</tr>
  			<tr>
  				<td>�������</td>
  				<td><input type="text" name="num" value="<%=info.getNum() %>"></td>
  			</tr>
  			<tr>
  				<td>�ۻ���������</td>
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

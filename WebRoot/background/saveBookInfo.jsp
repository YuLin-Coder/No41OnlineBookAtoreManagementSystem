<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增图书基本信息</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveBookInfoServlet" method="post">
  		<table align="center">
  			<caption>新增图书基本信息</caption>
  			<tr>
  				<td>图书名称：</td>
  				<td><input type="text" name="bookName"></td>
  			</tr>
  			<tr>
  				<td>图书类别编号：</td>
  				<td><input type="text" name="bookTypeId"></td>
  			</tr>
  			<tr>
  				<td>作者：</td>
  				<td><input type="text" name="author"></td>
  			</tr>
  			<tr>
  				<td>出版社名称：</td>
  				<td><input type="text" name="pbName"></td>
  			</tr>
  			<tr>
  				<td>图书介绍：</td>
  				<td><input type="text" name="context"></td> 
  			</tr>
  			<tr>
  				<td>图书小图片：</td>
  				<td><input type="text" name="smallImg"></td>
  			</tr>
  			<tr>
  				<td>图书大图片：</td>
  				<td><input type="text" name="bigImg"></td>
  			</tr>
  			<tr>
  				<td>价格：</td>
  				<td><input type="text" name="price"></td>
  			</tr>
  			<tr>
  				<td>出版日期：</td>
  				<td><input type="text" name="pbdate"></td>
  			</tr>
  			<tr>
  				<td>会员价：</td>
  				<td><input type="text" name="hyprice"></td>
  			</tr>
  			<tr>
  				<td>图书状态：</td>
  				<td><input type="text" name="bookStates"></td>
  			</tr>
  			<tr>
  				<td>上架时间：</td>
  				<td><input type="text" name="sjdate"></td>
  			</tr>
  			<tr>
  				<td>库存量：</td>
  				<td><input type="text" name="num"></td>
  			</tr>
  			<tr>
  				<td>累积销售量：</td>
  				<td><input type="text" name="saleCount"></td>
  			</tr>
  			<tr>
     		<td><input type="submit" value="submit"/></td>
     		<td><input type="reset" value="reset"/></td>
     	</tr>
  		</table>
  	</form>
  </body>
</html>

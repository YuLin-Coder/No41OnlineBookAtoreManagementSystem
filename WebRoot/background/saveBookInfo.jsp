<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����ͼ�������Ϣ</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/addUpdate.css';
    </style>
  </head>
  
  <body>
  	<form action="<%=request.getContextPath()%>/SaveBookInfoServlet" method="post">
  		<table align="center">
  			<caption>����ͼ�������Ϣ</caption>
  			<tr>
  				<td>ͼ�����ƣ�</td>
  				<td><input type="text" name="bookName"></td>
  			</tr>
  			<tr>
  				<td>ͼ������ţ�</td>
  				<td><input type="text" name="bookTypeId"></td>
  			</tr>
  			<tr>
  				<td>���ߣ�</td>
  				<td><input type="text" name="author"></td>
  			</tr>
  			<tr>
  				<td>���������ƣ�</td>
  				<td><input type="text" name="pbName"></td>
  			</tr>
  			<tr>
  				<td>ͼ����ܣ�</td>
  				<td><input type="text" name="context"></td> 
  			</tr>
  			<tr>
  				<td>ͼ��СͼƬ��</td>
  				<td><input type="text" name="smallImg"></td>
  			</tr>
  			<tr>
  				<td>ͼ���ͼƬ��</td>
  				<td><input type="text" name="bigImg"></td>
  			</tr>
  			<tr>
  				<td>�۸�</td>
  				<td><input type="text" name="price"></td>
  			</tr>
  			<tr>
  				<td>�������ڣ�</td>
  				<td><input type="text" name="pbdate"></td>
  			</tr>
  			<tr>
  				<td>��Ա�ۣ�</td>
  				<td><input type="text" name="hyprice"></td>
  			</tr>
  			<tr>
  				<td>ͼ��״̬��</td>
  				<td><input type="text" name="bookStates"></td>
  			</tr>
  			<tr>
  				<td>�ϼ�ʱ�䣺</td>
  				<td><input type="text" name="sjdate"></td>
  			</tr>
  			<tr>
  				<td>�������</td>
  				<td><input type="text" name="num"></td>
  			</tr>
  			<tr>
  				<td>�ۻ���������</td>
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

<%@page import="com.bookstore.bean.BookType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ͼ������б�</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>

	<%
		List<BookType> bookList = (List<BookType>)request.getAttribute("bookList");
		int nowPage = Integer.parseInt((request.getAttribute("nowPage").toString()));
		int pageCount = Integer.parseInt((request.getAttribute("pageCount").toString()));
	 %>
	 
	 <script type="text/javascript">
		 function isDelete(bookTypeName) {
		 	return confirm("��Ҫɾ�� " + bookTypeName + " ��?");
		 }
		 function gotoNowPage(nowPage) {
		 	if(isNaN(nowPage)) {
		 		alert("���������ͣ�");
		 		return;
		 	}
		 	if(nowPage <= 0 || nowPage > <%=pageCount%>) {
		 		alert("������ҳ�뷶Χ�ڵ�������");
		 		return;
		 	}
		 	location="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage="+nowPage;
		 }
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>ͼ������б�</caption>
  		<tr>
	  		<th>ͼ�������</th>
	  		<th>�����</th>
	  		<th>ͼ���������</th>
	  		<th>��ע</th>
	  		<th>�Ƿ����</th>
	  		<th>�޸�</th>
	  		<th>ɾ��</th>
  		</tr>
  		<%for(BookType books : bookList) { %>
  			<tr>
  				<td><%=books.getBookTypeId() %></td>
  				<td><%=books.getParentId() %></td>
  				<td><%=books.getBookTypeName() %></td>
  				<td><%=books.getContext() %></td>
  				<td><%=books.getIsDelete() %></td>
  				<td><a href="<%=request.getContextPath()%>/FindByBookTypeIdServlet?id=<%=books.getBookTypeId()%>">update</a></td>
  				<td><a href="<%=request.getContextPath() %>/DeleteBookTypeServlet?id=<%=books.getBookTypeId()%>"
  					onclick="return isDelete('<%=books.getBookTypeName()%>');">delete</a></td>
  			</tr>
  		<%} %>
  		<tr>
  			<td colspan="7">
  			<a href="<%=request.getContextPath()%>/background/saveBookType.jsp">����</a>
  			��<%=pageCount%>ҳ
  			��<%=nowPage%>ҳ
  			<%if(nowPage == 1) { %>
  				��һҳ ��һҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=1">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				��һҳ ���ҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=pageCount%>">���ҳ</a>
  			<%} %>
  			
  			<select onchange="gotoNowPage(this.value)">
  				<%for(int i = 1; i <= pageCount; i++) { %>
  					<option value="<%=i%>"
  						<% if(nowPage == i) {out.print("selected");}
  						%>
  					>��<%=i%>ҳ</option>
  				<%} %>
  			</select>
  			
  			��<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">ҳ
  			</td>
  		</tr>
  	</table>
  </body>
</html>

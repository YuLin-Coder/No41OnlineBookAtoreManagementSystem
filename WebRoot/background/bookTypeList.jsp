<%@page import="com.bookstore.bean.BookType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书类别列表</title>
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
		 	return confirm("您要删除 " + bookTypeName + " 吗?");
		 }
		 function gotoNowPage(nowPage) {
		 	if(isNaN(nowPage)) {
		 		alert("请输入整型！");
		 		return;
		 	}
		 	if(nowPage <= 0 || nowPage > <%=pageCount%>) {
		 		alert("请输入页码范围内的整数！");
		 		return;
		 	}
		 	location="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage="+nowPage;
		 }
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>图书类别列表</caption>
  		<tr>
	  		<th>图书类别编号</th>
	  		<th>父编号</th>
	  		<th>图书类别名称</th>
	  		<th>备注</th>
	  		<th>是否可用</th>
	  		<th>修改</th>
	  		<th>删除</th>
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
  			<a href="<%=request.getContextPath()%>/background/saveBookType.jsp">新增</a>
  			共<%=pageCount%>页
  			第<%=nowPage%>页
  			<%if(nowPage == 1) { %>
  				第一页 上一页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=1">第一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=nowPage-1%>">上一页</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				下一页 最后页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=nowPage+1%>">下一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=pageCount%>">最后页</a>
  			<%} %>
  			
  			<select onchange="gotoNowPage(this.value)">
  				<%for(int i = 1; i <= pageCount; i++) { %>
  					<option value="<%=i%>"
  						<% if(nowPage == i) {out.print("selected");}
  						%>
  					>第<%=i%>页</option>
  				<%} %>
  			</select>
  			
  			第<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">页
  			</td>
  		</tr>
  	</table>
  </body>
</html>

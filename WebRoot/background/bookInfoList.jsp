<%@page import="com.bookstore.bean.BookInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书基本信息列表</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/body.css';
	</style>
    <%
    	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos");
    	int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    	int pageCount = Integer.parseInt((request.getAttribute("pageCount").toString()));
     %>
     <script type="text/javascript">
     	function isDelete(bookName) {
    		return confirm("您要删除[" + bookName + "]吗？");
    	}
    	
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("请输入整型数值！");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > <%=pageCount%>) {
    			alert("请输入页码范围内的数值！");
    			return;
    		}
    		
    		location = "<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage="+nowPage;
    	}
     </script>
  </head>
  
  <body>
  	<table border = "1">
  		<caption>图书基本信息表</caption>
  		<tr>
  			<th>图书编号</th>
  			<th>图书名称</th>
  			<th>图书类别编号</th>
  			<th>作者</th>
  			<th>出版社名称</th>
  			<th>图书介绍</th>
  			<th>图书小图片</th>
  			<th>图书大图片</th>
  			<th>价格</th>
  			<th>出版日期</th>
  			<th>会员价</th>
  			<th>图书状态</th>
  			<th>上架时间</th>
  			<th>库存量</th>
  			<th>累积销售量</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		
  		<%for(BookInfo books : bookInfos) { %>
  			<tr>
  				<td><%=books.getBookId() %></td>
  				<td><%=books.getBookName() %></td>
  				<td><%=books.getBooktypeId() %></td>
  				<td><%=books.getAuthor() %></td>
  				<td><%=books.getPbName() %></td>
  				<td><%=books.getContext() %></td>
  				<td><%=books.getSmallImg() %></td>
  				<td><%=books.getBigImg() %></td>
  				<td><%=books.getPrice() %></td>
  				<td><%=books.getPbdate() %></td>
  				<td><%=books.getHyprice() %></td>
  				<td><%=books.getBookStates() %></td>
  				<td><%=books.getSjdate() %></td>
  				<td><%=books.getNum() %></td>
  				<td><%=books.getSaleCount() %></td>
  				<td><a href="<%=request.getContextPath() %>/FindByBookInfoIdServlet?id=<%=books.getBookId() %>">update</a></td>
  				<td><a href="<%=request.getContextPath() %>/DeleteBookInfoServlet?id=<%=books.getBookId()%>"
  					onclick="return isDelete('<%=books.getBookName()%>');">delete</a></td>
  			</tr>
  		<%} %>
  		<tr>
  			<td colspan="17">
  			<a href="<%=request.getContextPath()%>/background/saveBookInfo.jsp">新增</a>
  			共<%=pageCount %>页
  			第<%=nowPage %>页
  			<%if(nowPage == 1) { %>
  				第一页 上一页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=1">第一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=nowPage-1%>">上一页</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				下一页 最后页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=nowPage+1%>">下一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=pageCount%>">最后页</a>
  			<%} %>
  			
  			<select onchange="gotoNowPage(this.value)">
  		 		<%for(int i = 1; i <= pageCount; i++) { %>
  		 			<option value="<%=i%>"
  		 				<%if(nowPage == i) {
  		 					out.print("selected");
  		 				} %>
  		 			>第<%=i%>页</option>
  		 		<%} %>
  		 	</select>
  		 	
  		 	第
  		 	<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">
  		 	页
  		 	
  			</td>
  		</tr>
  		</table>
  </body>
</html>

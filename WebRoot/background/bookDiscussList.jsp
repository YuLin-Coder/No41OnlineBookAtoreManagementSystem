<%@page import="com.bookstore.bean.BookDiscuss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书评价列表</title>
    <style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/body.css';
	</style>
    <%
    	List<BookDiscuss> books = (List<BookDiscuss>)request.getAttribute("books");
    	int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    	int pageCount = Integer.parseInt((request.getAttribute("pageCount").toString()));
     %>
  	<script type="text/javascript">
     	function isDelete(disId) {
    		return confirm("您要删除[" + disId + "]吗？");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllBookDiscussServlet?nowPage="+nowPage;
    	}
     </script>
     </head>
  <body>
    <table border = "1">
  		<caption>图书评论表</caption>
  		<tr>
  			<th>书评编号</th>
  			<th>图书编号</th>
  			<th>用户编号</th>
  			<th>书评内容</th>
  			<th>书评状态</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		<%for(BookDiscuss book : books) { %>
  			<tr>
  				<td><%=book.getDisId() %></td>
  				<td><%=book.getBookId() %></td>
  				<td><%=book.getCustId() %></td>
  				<td><%=book.getContext() %></td>
  				<td><%=book.getStates() %></td>
  				<td><a href="<%=request.getContextPath() %>/FindByBookDiscussIdServlet?id=<%=book.getDisId()%>">update</a></td>
  				<td><a href="<%=request.getContextPath() %>/DeleteBookDiscussServlet?id=<%=book.getDisId()%>"
  					onclick="return isDelete('<%=book.getDisId()%>');">delete</a></td>
  			</tr>
  		<%} %>
  		<tr>
  			<td colspan="7">
  			<a href="<%=request.getContextPath()%>/background/saveBookDiscuss.jsp">新增</a>
  			共<%=pageCount %>页
  			第<%=nowPage %>页
  			<%if(nowPage == 1) { %>
  				上一页 下一页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=1">第一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=nowPage-1%>">上一页</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				下一页 最后页
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=nowPage+1%>">下一页</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=pageCount%>">最后页</a>
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
  		 	第<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">页
  			</td>
  		</tr>
  	</table>
  </body>
</html>



<%@page import="com.bookstore.bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻发布表</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
    <%
    	List<News> newsList = (List<News>)request.getAttribute("news");
    	int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    	int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
     %>
    <script type="text/javascript">
    	function isDelete(newTitle) {
    		return confirm("您要删除[" + newTitle + "]吗？");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllNewsServlet?nowPage="+nowPage;
    	}
    </script>
  </head>
  
  <body>
  	<table border = "1">
  		<caption>新闻发布表</caption>
  		<tr>
  			<th>新闻编号</th>
  			<th>新闻标题</th>
  			<th>新闻内容</th>
  			<th>新闻发布时间</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		
  		<%
  		for(News n : newsList) {%>
  			<tr>
  				<td><%=n.getNewsId() %></td>
  				<td><%=n.getNewTitle() %></td>
  				<td><%=n.getContext() %></td>
  				<td><%=n.getCreateTime() %></td>
  				<td><a href="<%=request.getContextPath() %>/FindByNewsIdServlet?id=<%=n.getNewsId() %>" >update</a></td>
  				<td><a href="<%=request.getContextPath() %>/DeleteNewsServlet?id=<%=n.getNewsId()%>"
  					onclick="return isDelete('<%=n.getNewTitle() %>');">delete</a></td>
  			</tr>
  		<% 
  		}
  		%>	
  		<tr>
  			<td colspan="6">
  		 	<a href="<%=request.getContextPath()%>/background/saveNews.jsp">增加</a>
  				共<%=pageCount %>页
  				第<%=nowPage %>页
  				<%if(nowPage == 1) { %>
  					第一页 上一页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1">第一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage-1%>">上一页</a>
  				<%} %>
  				<%if(nowPage == pageCount) { %>
  					下一页 最后页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage+1%>">下一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=pageCount%>">最后页</a>
  				<%} %>
	  			<select onchange="gotoNowPage(this.value)">
	    		<%for(int i = 1; i <= pageCount; i++ ){ %>
	    			<option value = "<%=i %>"
	    			<%if(nowPage == i){ %>selected
	    			<%} %>
	    			>第<%=i%>页</option>
	    		<% }%>
	    		</select>
	  		 	第<input size = '2' value = "<%=nowPage %>" onchange="gotoNowPage(this.value)">页
  			</td>
  		</tr>
  	</table>
  </body>
</html>

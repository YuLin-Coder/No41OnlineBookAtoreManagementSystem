<%@page import="com.bookstore.bean.Favorite"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'favoriteList.jsp' starting page</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
	<%
		int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		List<Favorite> favorites = (List<Favorite>)request.getAttribute("favorites");
	 %>
	 <script type="text/javascript">
	 	function isDelete(favId) {
	 		return confirm("您要删除 "+ favId +" 吗？");
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
    		location = "<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
    <table border="1">
    	<caption>收藏夹信息列表</caption>
    	<tr>
    		<th>收藏夹编号</th>
    		<th>图书编号</th>
    		<th>用户编号</th>
    		<th>收藏时间</th>
    		<th>备注</th>
    		<th>修改</th>
    		<th>删除</th>
    	</tr>
    	<%for(Favorite favorite : favorites) { %>
    		<tr>
    			<td><%=favorite.getFavoriteId()%></td>
    			<td><%=favorite.getBookId()%></td>
    			<td><%=favorite.getCustId()%></td>
    			<td><%=favorite.getScdate()%></td>
    			<td><%=favorite.getContext()%></td>
    			<td><a href="<%=request.getContextPath()%>/FindByFavIdServlet?id=<%=favorite.getFavoriteId()%>">update</a></td>
    			<td><a href="<%=request.getContextPath()%>/DeleteFavServlet?id=<%=favorite.getFavoriteId()%>"
    				 onclick="return isDelete('<%=favorite.getFavoriteId()%>');">delete</a></td>
    		</tr>
    	<%} %>
    	<tr>
    		<td colspan="7">
    			<a href="<%=request.getContextPath()%>/background/saveFav.jsp">增加</a>
    			共<%=pageCount%>页
    			第<%=nowPage%>页
    			<%if(nowPage == 1) { %>
    				第一页 上一页
    			<%} else { %>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=1">第一页</a>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=nowPage-1%>">上一页</a>
    			<%} %>
    			<%if(nowPage == pageCount) { %>
    				下一页 最后页
    			<%} else { %>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=nowPage+1%>">下一页</a>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=pageCount%>">最后页</a>
    			<%} %>
    			<select onchange="gotoNowPage(this.value)">
    				<%for(int i = 1; i <= pageCount; i++) { %>
    					<option value="<%=i%>" <%if(nowPage==i) {out.print("selected");}%>>第<%=i%>页</option>
    				<%} %>
    			</select>
    			第<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">页
    		</td>
    	</tr>
    </table>
  </body>
</html>

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
	 		return confirm("��Ҫɾ�� "+ favId +" ��");
	 	}
	 	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("������������ֵ��");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > <%=pageCount%>) {
    			alert("������ҳ�뷶Χ�ڵ���ֵ��");
    			return;
    		}
    		location = "<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
    <table border="1">
    	<caption>�ղؼ���Ϣ�б�</caption>
    	<tr>
    		<th>�ղؼб��</th>
    		<th>ͼ����</th>
    		<th>�û����</th>
    		<th>�ղ�ʱ��</th>
    		<th>��ע</th>
    		<th>�޸�</th>
    		<th>ɾ��</th>
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
    			<a href="<%=request.getContextPath()%>/background/saveFav.jsp">����</a>
    			��<%=pageCount%>ҳ
    			��<%=nowPage%>ҳ
    			<%if(nowPage == 1) { %>
    				��һҳ ��һҳ
    			<%} else { %>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=1">��һҳ</a>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
    			<%} %>
    			<%if(nowPage == pageCount) { %>
    				��һҳ ���ҳ
    			<%} else { %>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
    				<a href="<%=request.getContextPath()%>/FindAllFavoriteServlet?nowPage=<%=pageCount%>">���ҳ</a>
    			<%} %>
    			<select onchange="gotoNowPage(this.value)">
    				<%for(int i = 1; i <= pageCount; i++) { %>
    					<option value="<%=i%>" <%if(nowPage==i) {out.print("selected");}%>>��<%=i%>ҳ</option>
    				<%} %>
    			</select>
    			��<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">ҳ
    		</td>
    	</tr>
    </table>
  </body>
</html>

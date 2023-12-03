<%@page import="com.bookstore.bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>���ŷ�����</title>
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
    		return confirm("��Ҫɾ��[" + newTitle + "]��");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllNewsServlet?nowPage="+nowPage;
    	}
    </script>
  </head>
  
  <body>
  	<table border = "1">
  		<caption>���ŷ�����</caption>
  		<tr>
  			<th>���ű��</th>
  			<th>���ű���</th>
  			<th>��������</th>
  			<th>���ŷ���ʱ��</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
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
  		 	<a href="<%=request.getContextPath()%>/background/saveNews.jsp">����</a>
  				��<%=pageCount %>ҳ
  				��<%=nowPage %>ҳ
  				<%if(nowPage == 1) { %>
  					��һҳ ��һҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
  				<%} %>
  				<%if(nowPage == pageCount) { %>
  					��һҳ ���ҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=pageCount%>">���ҳ</a>
  				<%} %>
	  			<select onchange="gotoNowPage(this.value)">
	    		<%for(int i = 1; i <= pageCount; i++ ){ %>
	    			<option value = "<%=i %>"
	    			<%if(nowPage == i){ %>selected
	    			<%} %>
	    			>��<%=i%>ҳ</option>
	    		<% }%>
	    		</select>
	  		 	��<input size = '2' value = "<%=nowPage %>" onchange="gotoNowPage(this.value)">ҳ
  			</td>
  		</tr>
  	</table>
  </body>
</html>

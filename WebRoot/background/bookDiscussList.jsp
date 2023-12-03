<%@page import="com.bookstore.bean.BookDiscuss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ͼ�������б�</title>
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
    		return confirm("��Ҫɾ��[" + disId + "]��");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllBookDiscussServlet?nowPage="+nowPage;
    	}
     </script>
     </head>
  <body>
    <table border = "1">
  		<caption>ͼ�����۱�</caption>
  		<tr>
  			<th>�������</th>
  			<th>ͼ����</th>
  			<th>�û����</th>
  			<th>��������</th>
  			<th>����״̬</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
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
  			<a href="<%=request.getContextPath()%>/background/saveBookDiscuss.jsp">����</a>
  			��<%=pageCount %>ҳ
  			��<%=nowPage %>ҳ
  			<%if(nowPage == 1) { %>
  				��һҳ ��һҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=1">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=nowPage-1%>">��һҳ</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				��һҳ ���ҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=nowPage+1%>">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookDiscussServlet
  						?nowPage=<%=pageCount%>">���ҳ</a>
  			<%} %>
  			<select onchange="gotoNowPage(this.value)">
  		 		<%for(int i = 1; i <= pageCount; i++) { %>
  		 			<option value="<%=i%>"
  		 				<%if(nowPage == i) {
  		 					out.print("selected");
  		 				} %>
  		 			>��<%=i%>ҳ</option>
  		 		<%} %>
  		 	</select>
  		 	��<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">ҳ
  			</td>
  		</tr>
  	</table>
  </body>
</html>



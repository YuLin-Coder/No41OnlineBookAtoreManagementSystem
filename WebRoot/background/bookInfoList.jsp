<%@page import="com.bookstore.bean.BookInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ͼ�������Ϣ�б�</title>
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
    		return confirm("��Ҫɾ��[" + bookName + "]��");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage="+nowPage;
    	}
     </script>
  </head>
  
  <body>
  	<table border = "1">
  		<caption>ͼ�������Ϣ��</caption>
  		<tr>
  			<th>ͼ����</th>
  			<th>ͼ������</th>
  			<th>ͼ�������</th>
  			<th>����</th>
  			<th>����������</th>
  			<th>ͼ�����</th>
  			<th>ͼ��СͼƬ</th>
  			<th>ͼ���ͼƬ</th>
  			<th>�۸�</th>
  			<th>��������</th>
  			<th>��Ա��</th>
  			<th>ͼ��״̬</th>
  			<th>�ϼ�ʱ��</th>
  			<th>�����</th>
  			<th>�ۻ�������</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
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
  			<a href="<%=request.getContextPath()%>/background/saveBookInfo.jsp">����</a>
  			��<%=pageCount %>ҳ
  			��<%=nowPage %>ҳ
  			<%if(nowPage == 1) { %>
  				��һҳ ��һҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=1">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
  			<%} %>
  			<%if(nowPage == pageCount) { %>
  				��һҳ ���ҳ
  			<%} else { %>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage=<%=pageCount%>">���ҳ</a>
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
  		 	
  		 	��
  		 	<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">
  		 	ҳ
  		 	
  			</td>
  		</tr>
  		</table>
  </body>
</html>

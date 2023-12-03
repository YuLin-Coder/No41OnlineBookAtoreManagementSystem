<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.bean.SysAdmin"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<%
	List<SysAdmin> adminList = (List<SysAdmin>)request.getAttribute("admins"); 
	int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
	int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
	%>
  <head>
    <title>����Ա��</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
     <script type="text/javascript">
     	function isDelete(adminName) {
    		return confirm("��Ҫɾ�� " + adminName + " ��");
    	}
    	
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("������������ֵ��");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > ${requestScope.pageCount}) {
    			alert("������ҳ�뷶Χ�ڵ���ֵ��");
    			return;
    		}
    		location = "<%=request.getContextPath()%>/FindAllAdminServlet?nowPage="+nowPage;
    	}
     </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>����Ա�б�</caption>
  		<tr>
  			<th>����Ա���</th>
  			<th>����Ա����</th>
  			<th>����Ա����</th>
  			<th>����Ա����</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
  		</tr>
  		<%for(SysAdmin admin : adminList) { %>
	    	<tr>
	    		<td><%=admin.getAdminId() %></td>
	    		<td><%=admin.getAdminName() %></td>
	    		<td><%=admin.getPwd() %></td>
	    		<td><%=admin.getAdminType() %></td>
	    		<td><a href = "<%=request.getContextPath() %>/FindByAdminIdServlet?id=<%=admin.getAdminId() %>">�޸�</a></td>
	    		<td><a href = "<%=request.getContextPath() %>/DeleteAdminServlet?id=<%=admin.getAdminId() %>"
	    		onclick = "return isDelete('<%=admin.getAdminName() %>')">ɾ��</a></td>
	    	</tr>
    	 <% }%>
  		 <tr>
  		 	<td colspan = '6'><a href = "<%=request.getContextPath() %>/background/saveAdmin.jsp">����</a>
    		&nbsp;��<%=pageCount %>ҳ &nbsp;
    		��<%=nowPage %>ҳ &nbsp;
  		 	<%if(nowPage == 1) { %>
    		��һҳ&nbsp;��һҳ&nbsp;
    		<% } else {%>
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=1">��һҳ</a>&nbsp;
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=nowPage - 1 %>">��һҳ</a>&nbsp;
    		<%} %>
    		<%if(nowPage == pageCount) { %>
    		��һҳ&nbsp;���ҳ&nbsp;
    		<% } else {%>
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=nowPage + 1 %>">��һҳ</a>&nbsp;
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=pageCount %>">���ҳ</a>&nbsp;
    		<%} %>
  		 	<select onchange="gotoNowPage(this.value)">
    		<%for(int i = 1; i <= pageCount; i++ ){ %>
    			<option value = "<%=i %>"
    			<%if(nowPage == i){ %>selected
    			<%} %>
    			>��<%=i%>ҳ</option>
    		<% }%>
    		</select>&nbsp;
  		 	��<input size = '2' value = "<%=nowPage %>" onchange="gotoNowPage(this.value)">ҳ
  		 	</td>
  		 </tr>
  	</table>
  </body>
</html>

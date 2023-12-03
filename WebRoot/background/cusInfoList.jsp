<%@page import="com.bookstore.bean.CustomerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�û�������Ϣ�б�</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
    
	<%
		List<CustomerInfo> infos = (List<CustomerInfo>)request.getAttribute("infos");
		int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
	 %>
	 
	 <script type="text/javascript">
	 	function isDelete(custName) {
	 		return confirm("��Ҫɾ��[" + custName + "]��");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>�û�������Ϣ��</caption>
  		<tr>
  			<th>�û����</th>
  			<th>�û�����</th>
  			<th>�û�����</th>
  			<th>�û�����</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
  		</tr>
  		<%for(CustomerInfo info : infos) { %>
  			<tr>
  				<td><%=info.getCustId() %></td>
  				<td><%=info.getCustName() %></td>
  				<td><%=info.getPwd() %></td>
  				<td><%=info.getEmail() %></td>
  				<td><a href="<%=request.getContextPath()%>/FindByCustomerInfoServlet?id=<%=info.getCustId()%>">update</a></td>
  				<td><a href="<%=request.getContextPath()%>/DeleteCustomerInfoServlet?id=<%=info.getCustId()%>"
  						onclick="return isDelete('<%=info.getCustName()%>');">delete</a></td>
  			</tr>
  		<%} %>
  		
  		<tr>
  			<td colspan="6">
  				<a href="<%=request.getContextPath()%>/background/saveCusInfo.jsp">����</a>
  				��<%=pageCount %>ҳ
  				��<%=nowPage %>ҳ
  				<%if(nowPage == 1) { %>
  					��һҳ ��һҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=1">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
  				<%} %>
  				<%if(nowPage == pageCount) { %>
  					��һҳ ���ҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=pageCount%>">���ҳ</a>
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

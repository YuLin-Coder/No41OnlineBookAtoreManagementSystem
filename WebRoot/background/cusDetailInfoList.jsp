<%@page import="com.bookstore.bean.CustomerDetailInfo"%>
<%@page import="com.bookstore.bean.CustomerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�û���ϸ��Ϣ�б�</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
    
	<%
		int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		List<CustomerDetailInfo> infos = (List<CustomerDetailInfo>)request.getAttribute("infos");
	 %>
	 
	 <script type="text/javascript">
	 	function isDelete(custId) {
	 		return confirm("��Ҫɾ��[" + custId + "]��");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>�û���ϸ��Ϣ��</caption>
  		<tr>
  			<th>�û����</th>
  			<th>�û���ϵ�绰</th>
  			<th>�û���ַ</th>
  			<th>�û��Ա�</th>
  			<th>�û�����</th>
  			<th>�û��ۼ����ѽ��</th>
  			<th>�û�qq����</th>
  			<th>�޸�</th>
  			<th>ɾ��</th>
  		</tr>
  		<%for(CustomerDetailInfo info : infos) { %>
  			<tr>
  				<td><%=info.getCustId() %></td>
  				<td><%=info.getTel() %></td>
  				<td><%=info.getAddress() %></td>
  				<td><%=info.getSex() %></td>
  				<td><%=info.getAge() %></td>
  				<td><%=info.getCountMoney() %></td>
  				<td><%=info.getQq() %></td>
  				<td><a href="<%=request.getContextPath()%>/FindByCusDetailInfoServlet?id=<%=info.getCustId()%>">update</a></td>
  				<td><a href="<%=request.getContextPath()%>/DeleteCusDetailInfoServlet?id=<%=info.getCustId()%>"
  						onclick="return isDelete('<%=info.getCustId()%>');">delete</a></td>
  			</tr>
  		<%} %>
  		
  		<tr>
  			<td colspan="9">
  				<a href="<%=request.getContextPath()%>/background/saveCusDetailInfo.jsp">����</a>
  				��<%=pageCount %>ҳ
  				��<%=nowPage %>ҳ
  				<%if(nowPage == 1) { %>
  					��һҳ ��һҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=1">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
  				<%} %>
  				
  				<%if(nowPage == pageCount) { %>
  					��һҳ ���ҳ
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=nowPage+1%>">��һҳ</a>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=pageCount%>">���ҳ</a>
  				<%} %>
  				
  				<select onchange="gotoNowPage(this.value)">
  					<%for(int i = 1; i <= pageCount; i++) { %>
  						<option value="<%=i%>"
  							<%if(nowPage == i) {out.print("selected");} %>
  						>��<%=i%>ҳ</option>
  					<%} %>
  				</select>
  				
  				��<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">ҳ
  			</td>
  		</tr>
  	</table>
  </body>
</html>

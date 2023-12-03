<%@page import="com.bookstore.bean.CustomerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户基本信息列表</title>
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
	 		return confirm("您要删除[" + custName + "]吗？");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>用户基本信息表</caption>
  		<tr>
  			<th>用户编号</th>
  			<th>用户名称</th>
  			<th>用户密码</th>
  			<th>用户邮箱</th>
  			<th>修改</th>
  			<th>删除</th>
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
  				<a href="<%=request.getContextPath()%>/background/saveCusInfo.jsp">增加</a>
  				共<%=pageCount %>页
  				第<%=nowPage %>页
  				<%if(nowPage == 1) { %>
  					第一页 上一页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=1">第一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=nowPage-1%>">上一页</a>
  				<%} %>
  				<%if(nowPage == pageCount) { %>
  					下一页 最后页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=nowPage+1%>">下一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=pageCount%>">最后页</a>
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

<%@page import="com.bookstore.bean.CustomerDetailInfo"%>
<%@page import="com.bookstore.bean.CustomerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户详细信息列表</title>
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
	 		return confirm("您要删除[" + custId + "]吗？");
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
    		
    		location = "<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage="+nowPage;
    	}
	 </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>用户详细信息表</caption>
  		<tr>
  			<th>用户编号</th>
  			<th>用户联系电话</th>
  			<th>用户地址</th>
  			<th>用户性别</th>
  			<th>用户年龄</th>
  			<th>用户累计消费金额</th>
  			<th>用户qq号码</th>
  			<th>修改</th>
  			<th>删除</th>
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
  				<a href="<%=request.getContextPath()%>/background/saveCusDetailInfo.jsp">增加</a>
  				共<%=pageCount %>页
  				第<%=nowPage %>页
  				<%if(nowPage == 1) { %>
  					第一页 上一页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=1">第一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=nowPage-1%>">上一页</a>
  				<%} %>
  				
  				<%if(nowPage == pageCount) { %>
  					下一页 最后页
  				<%} else { %>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=nowPage+1%>">下一页</a>
  					<a href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=<%=pageCount%>">最后页</a>
  				<%} %>
  				
  				<select onchange="gotoNowPage(this.value)">
  					<%for(int i = 1; i <= pageCount; i++) { %>
  						<option value="<%=i%>"
  							<%if(nowPage == i) {out.print("selected");} %>
  						>第<%=i%>页</option>
  					<%} %>
  				</select>
  				
  				第<input size="2" value="<%=nowPage %>" onchange="gotoNowPage(this.value)">页
  			</td>
  		</tr>
  	</table>
  </body>
</html>

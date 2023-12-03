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
    <title>管理员表</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css';
    </style>
     <script type="text/javascript">
     	function isDelete(adminName) {
    		return confirm("您要删除 " + adminName + " 吗？");
    	}
    	
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("请输入整型数值！");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > ${requestScope.pageCount}) {
    			alert("请输入页码范围内的数值！");
    			return;
    		}
    		location = "<%=request.getContextPath()%>/FindAllAdminServlet?nowPage="+nowPage;
    	}
     </script>
  </head>
  
  <body>
  	<table border="1">
  		<caption>管理员列表</caption>
  		<tr>
  			<th>管理员编号</th>
  			<th>管理员姓名</th>
  			<th>管理员密码</th>
  			<th>管理员级别</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		<%for(SysAdmin admin : adminList) { %>
	    	<tr>
	    		<td><%=admin.getAdminId() %></td>
	    		<td><%=admin.getAdminName() %></td>
	    		<td><%=admin.getPwd() %></td>
	    		<td><%=admin.getAdminType() %></td>
	    		<td><a href = "<%=request.getContextPath() %>/FindByAdminIdServlet?id=<%=admin.getAdminId() %>">修改</a></td>
	    		<td><a href = "<%=request.getContextPath() %>/DeleteAdminServlet?id=<%=admin.getAdminId() %>"
	    		onclick = "return isDelete('<%=admin.getAdminName() %>')">删除</a></td>
	    	</tr>
    	 <% }%>
  		 <tr>
  		 	<td colspan = '6'><a href = "<%=request.getContextPath() %>/background/saveAdmin.jsp">新增</a>
    		&nbsp;共<%=pageCount %>页 &nbsp;
    		第<%=nowPage %>页 &nbsp;
  		 	<%if(nowPage == 1) { %>
    		第一页&nbsp;上一页&nbsp;
    		<% } else {%>
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=1">第一页</a>&nbsp;
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=nowPage - 1 %>">上一页</a>&nbsp;
    		<%} %>
    		<%if(nowPage == pageCount) { %>
    		下一页&nbsp;最后页&nbsp;
    		<% } else {%>
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=nowPage + 1 %>">下一页</a>&nbsp;
    		<a href = "<%=request.getContextPath() %>/FindAllAdminServlet?nowPage=<%=pageCount %>">最后页</a>&nbsp;
    		<%} %>
  		 	<select onchange="gotoNowPage(this.value)">
    		<%for(int i = 1; i <= pageCount; i++ ){ %>
    			<option value = "<%=i %>"
    			<%if(nowPage == i){ %>selected
    			<%} %>
    			>第<%=i%>页</option>
    		<% }%>
    		</select>&nbsp;
  		 	第<input size = '2' value = "<%=nowPage %>" onchange="gotoNowPage(this.value)">页
  		 	</td>
  		 </tr>
  	</table>
  </body>
</html>

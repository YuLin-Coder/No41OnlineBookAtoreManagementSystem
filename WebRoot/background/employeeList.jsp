<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工信息列表</title>
    <style type="text/css">
    	@import '${pageContext.request.contextPath}/background/css/body.css'
    </style>
    <script type="text/javascript">
    	function isDelete(empName) {
    		return confirm("您要删除[" + empName + "]吗?");
    	}
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("输入的页码必须是数字!!");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > ${requestScope.pageCount}) {
    			alert("您输入的页码超出范围!!");
    			return;
    		}
    		location = "${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=" + nowPage;
    	}
    </script>
  </head>
  
  <body>
    	<table border="1">
    		<caption>员工信息列表</caption>
    		<tr>
    			<th>员工编号</th>
    			<th>员工姓名</th>
    			<th>员工生日</th>
    			<th>员工性别</th>
    			<th>员工年龄</th>
    			<th>修改</th>
    			<th>删除</th>
    		</tr>
    		<c:forEach var="emp" items="${requestScope.emps}">
    			<tr onmouseover="this.bgColor='red'" onmouseout="this.bgColor='white'">
    				<td>${emp.empId}</td>
    				<td>${emp.empName}</td>
    				<td>${emp.empBtd}</td>
    				<td>${emp.empSex}</td>
    				<td>${emp.empAge}</td>
    				<td><a href="${pageContext.request.contextPath}/FindByEmpIdServlet?id=${emp.empId}">update</a></td>
    				<td><a href="${pageContext.request.contextPath}/DeleteEmpServlet?id=${emp.empId}"
    					onclick="return isDelete('${emp.empName}');">delete</a></td>    			
    			</tr>	
    		</c:forEach>
    		<tr>
    			<td colspan="7">
    				<a href="${pageContext.request.contextPath}/background/saveEmp.jsp">新增</a>
    				共${requestScope.pageCount}页
    				第${requestScope.nowPage}页
    				<c:if test="${nowPage == 1}" var="result">
    					第一页 上一页
    				</c:if>
    				<c:if test="${!result}">
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=1">第一页</a>
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${nowPage - 1}">上一页</a>
    				</c:if>
    				<c:if test="${nowPage == pageCount}" var="result">
    					下一页 最后页	
    				</c:if>
    				<c:if test="${!result}">
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${nowPage + 1}">下一页</a>
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${pageCount}">最后页</a>
    				</c:if>
    				
    				<select onchange="gotoNowPage(this.value)">
    					<c:forEach begin="1" end="${requestScope.pageCount}"
    					varStatus="status">
    						<option value="${status.count}"
    						<c:if test="${status.count == nowPage}">selected</c:if>
    						>第${status.count}页</option>
    					</c:forEach>    					
    				</select>	 
					第
					<input size="2" value="${nowPage}" onchange="gotoNowPage(this.value)">
					页	
    			</td>
    		</tr>
    	</table>
  </body>
</html>

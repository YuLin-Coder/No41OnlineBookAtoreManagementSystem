<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Ա����Ϣ�б�</title>
    <style type="text/css">
    	@import '${pageContext.request.contextPath}/background/css/body.css'
    </style>
    <script type="text/javascript">
    	function isDelete(empName) {
    		return confirm("��Ҫɾ��[" + empName + "]��?");
    	}
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("�����ҳ�����������!!");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > ${requestScope.pageCount}) {
    			alert("�������ҳ�볬����Χ!!");
    			return;
    		}
    		location = "${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=" + nowPage;
    	}
    </script>
  </head>
  
  <body>
    	<table border="1">
    		<caption>Ա����Ϣ�б�</caption>
    		<tr>
    			<th>Ա�����</th>
    			<th>Ա������</th>
    			<th>Ա������</th>
    			<th>Ա���Ա�</th>
    			<th>Ա������</th>
    			<th>�޸�</th>
    			<th>ɾ��</th>
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
    				<a href="${pageContext.request.contextPath}/background/saveEmp.jsp">����</a>
    				��${requestScope.pageCount}ҳ
    				��${requestScope.nowPage}ҳ
    				<c:if test="${nowPage == 1}" var="result">
    					��һҳ ��һҳ
    				</c:if>
    				<c:if test="${!result}">
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=1">��һҳ</a>
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${nowPage - 1}">��һҳ</a>
    				</c:if>
    				<c:if test="${nowPage == pageCount}" var="result">
    					��һҳ ���ҳ	
    				</c:if>
    				<c:if test="${!result}">
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${nowPage + 1}">��һҳ</a>
    					<a href="${pageContext.request.contextPath}/FindAllEmployeeServlet?nowPage=${pageCount}">���ҳ</a>
    				</c:if>
    				
    				<select onchange="gotoNowPage(this.value)">
    					<c:forEach begin="1" end="${requestScope.pageCount}"
    					varStatus="status">
    						<option value="${status.count}"
    						<c:if test="${status.count == nowPage}">selected</c:if>
    						>��${status.count}ҳ</option>
    					</c:forEach>    					
    				</select>	 
					��
					<input size="2" value="${nowPage}" onchange="gotoNowPage(this.value)">
					ҳ	
    			</td>
    		</tr>
    	</table>
  </body>
</html>

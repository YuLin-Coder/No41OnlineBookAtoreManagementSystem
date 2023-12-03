<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸�Ա����Ϣ</title>
	<style type="text/css">
		@import '${pageContext.request.contextPath}/background/css/addUpdate.css'
	</style>
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath}/UpdateEmployeeServlet" method="post">
     	<table align="center">
     		<caption>�޸�Ա����Ϣ </caption>
     		<tr>
     			<td>Ա����ţ�</td>
     			<td><input type="text" name="empId" value="${requestScope.emp.empId}"
     			readonly></td>
     		</tr>
     		<tr>
     			<td>Ա��������</td>
     			<td><input type="text" name="empName" value="${requestScope.emp.empName}"></td>
     		</tr>
     		<tr>
     			<td>Ա�����䣺</td>
     			<td><input type="text" name="empAge" value="${requestScope.emp.empAge}"></td>
     		</tr>
     		<tr>
     			<td>Ա�����գ�</td>
     			<td><input type="text" name="empBtd" value="${requestScope.emp.empBtd}"></td>
     		</tr>
     		<tr>
     			<td>Ա���Ա�</td>
     			<td><input type="radio" name="empSex" value="1" 
     					<c:if test="${requestScope.emp.empSex == 1}">
     						checked
     					</c:if>
     				>��
     				<input type="radio" name="empSex" value="0"
	     				<c:if test="${requestScope.emp.empSex == 0}">
	     					checked
	     				</c:if>
     				>Ů
     			</td>
     		</tr>
     		<tr>
     			<td><input type="submit" value="submit"/></td>
     			<td><input type="reset" value="reset"/></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>

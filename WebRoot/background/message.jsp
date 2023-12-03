<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消息提示</title>
  </head>
  
  <body>
  	<h2 align="center"><%=request.getAttribute("msg")%></h2>
  	<h2 align="center"><a href="<%=request.getContextPath()%><%=request.getAttribute("returnPath")%>">返回</a></h2>
  </body>
</html>

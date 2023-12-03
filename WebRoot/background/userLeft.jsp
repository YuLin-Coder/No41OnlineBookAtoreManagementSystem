<%@ page language="java" contentType="text/html; charset=gbk"%>
	<table>
		<tr>
			<td background="images/ht04.jpg" class="wr4">
				<div align="center">用 户 管 理</div></td>
			<td width="12"><img src="images/ht03.jpg" width="12" height="20">
			</td>
		</tr>
	</table>
	<table width="160" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a
				href="<%= request.getContextPath() %>/FindAllAdminServlet?nowPage=1" target="mainFrame">管理员</a>
			</td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a
				href="<%= request.getContextPath() %>/FindAllEmployeeServlet?nowPage=1" target="mainFrame">员工信息管理</a>
			</td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a
				href="<%= request.getContextPath() %>/FindAllCustomerInfoServlet?nowPage=1" target="mainFrame">用户基本信息</a>
			</td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a
				href="<%=request.getContextPath()%>/FindAllCusDetailInfoServlet?nowPage=1" target="mainFrame">用户详细信息</a>
			</td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120">&nbsp;</td>
		</tr>
	</table>
	<table width="160" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td background="images/ht08.jpg" class="wr4">
				<div align="center">交 互 管 理</div></td>
			<td width="12"><img src="images/ht07.jpg" width="12" height="20">
			</td>
		</tr>
	</table>
	<table width="160" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a
				href="<%=request.getContextPath()%>/FindAllBookDiscussServlet?nowPage=1" target="mainFrame">图书评价</a>
			</td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a href="#">栏目管理</a></td>
		</tr>
		<tr>
			<td width="40">&nbsp;</td>
			<td class="wr4" width="120"><a href="#">访问分析</a></td>
		</tr>
	</table>
	<table width="160" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td background="images/ht04.jpg" class="wr4">
				<div align="center">
					<a href="systemSet.htm" target="mainFrame">系 统 设 置</a>
				</div></td>
			<td width="12"><img src="images/ht03.jpg" width="12" height="20">
			</td>
		</tr>
	</table>
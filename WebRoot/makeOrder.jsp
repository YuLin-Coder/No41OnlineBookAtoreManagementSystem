<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XhTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>�ҵĹ����</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/orderInfo.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
</head>

<body>
<div class="top1">
	<div class="top1_1">
   	��ӭ����¼�����̳ǣ�
   	�û�����<input type="text" name="name" value="${sessionScope.customerInfo.custName}" class="inputsty"/> 
   	���룺<input type="password" name="password" value="${sessionScope.customerInfo.pwd}" class="inputsty"/> 
   	<a href="#">��������?</a> 
   	<a href="${pageContext.request.contextPath}/qtLogin.jsp">��¼</a>
   	<a href="${pageContext.request.contextPath}/background/index.jsp">ע��</a>
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>����:<input type="text" name="" class="kuang" />  </li>
            	<li>����:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li>
	            	<a href="<%=request.getContextPath() %>/gouwuche.jsp">
	            	<img src="images/car.gif"/><br />���ﳵ</a>
            	</li>
				<li><a href="#"><img src="images/car.gif"/><br />������ѯ  </a></li>
				<li><a href="#"><img src="images/car.gif"/><br />�ҵĿռ�</a></li>
				<li><a href="#"><img src="images/car.gif"/><br />������� </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="<%=request.getContextPath() %>/InitIndexServlet">��ҳ</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">����</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">��ѧ</a></li>
                <li><a href="http://www.dangdang.com/">��ϵ</a></li>
                <li><a href="http://www.dangdang.com/">�Ļ�</a></li>
                <li><a href="http://www.dangdang.com/">��Ӫ</a></li>
            </ul>
        </div>
	</div>
</div>
<form action="${pageContext.request.contextPath}/MakeOrderServlet">
<div class="content" style="margin-top:-90px; width:1310px">
    	<div class="title2"></div>
        <!-- ����� -->
		<dl id="myCartTitle">
        	<dt>ȷ�϶�����Ϣ</dt>
        	<dd><a href="#" style="margin-right:-310px">�����ջ���ַ</a></dd> 
		 </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
		 <div class="address"> 
				<div id=part_consignee>
				<div class=o_write>
				<h1>�ջ�����Ϣ&nbsp;
                  <span style="DISPLAY: none"><a style="COLOR: #ff6600" onclick=addNewAddress(this); href="javascript:void(0)">[����һ���µ�ַ]</a></span> 
                </h1>
				<div class=middle>
				<div id=addressListPanel></div>
				<div id=consignee_addr>
				<TABLE border=0 cellSpacing=0 width="100%">
				  <TBODY>
				  <TR>
					<TD vAlign="middle" width=85 align=right><FONT color=red>*</FONT>�ջ���������</TD>
					<TD vAlign="middle" align=left>
					<INPUT value="${sessionScope.customerInfo.custName}"
					name="customerName" class=txt maxLength=20 type=text>&nbsp; </TD>
			     </TR>
				 
				  <TR>
					<TD vAlign="middle" align=right><FONT color=red>*</FONT>�ء���ַ��</TD>
					<TD vAlign="middle" align=left>
					<INPUT value="${sessionScope.customerDetailInfo.address}"
					  style="WIDTh: 327px;" id=consignee_address class=txt 
					  name="address" maxLength=50 type=text>&nbsp; </TD></TR>
				  <TR>
					<TD vAlign="middle" align=right><FONT color=red>*</FONT>�绰��</TD>
					<TD vAlign="middle" align=left>
					<INPUT value="${sessionScope.customerDetailInfo.tel}"
					  id=consignee_message class=txt name="tel"> &nbsp;<FONT 
					  color=#000000>���ڽ��շ���֪ͨ���ż��ͻ�ǰȷ��</FONT> </TD>
				 </TR>
				 <TR>
					<TD vAlign="middle" align=right>��ע��</TD>
					<TD vAlign="middle" align=left>
					<INPUT value="" name="context"
					  id="consignee_message" class="txt" name="tel"> </TD>
				 </TR>
				  <TR>
					<TD valign="middle" align="right">�����ʼ���</TD>
					<TD valign="middle" align="left">
					<INPUT value="${sessionScope.customerInfo.email}"
					  id=consignee_email class=txt type=text> &nbsp;<FONT 
					  color=#000000>�������ն��������ʼ�����������ʱ�˽ⶩ��״̬</FONT> </TD>
				  </TR>
				  </TBODY></TABLE></div></div>
				</div></div>
			<div id=part_payTypeAndShipType>
			<div class=o_show>
			<h1>֧�������ͷ�ʽ&nbsp;<A id=linkPayTypeShipType 
			onclick=showForm_payTypeAndShipType(this); href="javascript:void(0)">[�޸�]</A></h1>
			<div id=updateInfo_payType></div>
			<div class=middle>
			<TABLE style="WIDTh: 100%">
			  <TBODY>
			  <TR>
				<TD style="TEXT-ALIGN: right; WIDTh: 80px">֧����ʽ��</TD>
				<TD>����֧��</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">���ͷ�ʽ��</TD>
				<TD>�������</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">�ˡ����ѣ�</TD>
				<TD>0.00Ԫ<SPAN style="COLOR: red">(���˷�)</SPAN></TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">�ͻ����ڣ�</TD>
				<TD style="COLOR: red">{CodTime}</TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">����ʱ�䣺</TD>
				<TD style="COLOR: red">{PickTime}</TD></TR></TBODY></TABLE></div>
			<div class=footsty></div></div></div><!--֧����ʽ�����ͷ�ʽ����-->
			<!--��Ʊ��Ϣ��ʼ-->
<div id=part_invoice>
<div class=o_show>
<h1>��Ʊ��Ϣ&nbsp;<A onclick=showForm_invoice(this) href="javascript:void(0)">[�޸�]</A></h1>
<div class=middle>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
  style="TEXT-ALIGN: left; PADDING-LEFT: 22px">��ȡ���ͣ�&nbsp;Ĭ�Ͽ�ȡ</TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%">
  <TBODY>
  <TR>
    <TD style="TEXT-ALIGN: right; WIDTh: 82px">��Ʊ���ͣ�</TD>
    <TD>��ͨ��Ʊ</TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">��Ʊ̧ͷ��</TD>
    <TD>���� </TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">��Ʊ���ݣ�</TD>
    <TD>
      <div><SPAN style="DISPLAY: none">��ͼ����Ʒ��</SPAN><SPAN>��ϸ</SPAN></div>
      <div><SPAN style="DISPLAY: none">ͼ����Ʒ��</SPAN><SPAN 
      style="DISPLAY: none">������Ʊ</SPAN></div></TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
style="TEXT-ALIGN: left; PADDING-LEFT: 22px">������Ʊ</TD></TR></TBODY></TABLE></div>
<div class=footsty></div></div></div><!--��Ʊ��Ϣ����--><!--Cart��Ϣ��ʼ-->
<div id=part_cart></div><!--Cart��Ϣ��ʼ--><!--�л��ȷ���ʼ-->
<div style="PADDING-BOTTOM: 8px; PADDING-LEFT: 30px; PADDING-RIGhT: 0px; COLOR: red; PADDING-TOP: 8px" id=part_FirstInstockShip>
	<LABEL for=chk_FirstInstockShip>�ȷ��л���Ʒ���������������Ʒȱ�������������л���Ʒ��</LABEL> 
	</div>
</div>
	    <dl id="myCartTitle">
        	<dt>ȷ����ѡ����Ʒ</dt>
        	<dd>��</dd>        
	    </dl>
		<div class="clear"><img src="#" width="1" height="1"></div>
		<div id="myCartTable">
		<table width="100%" border="0" cellspacing="" cellpadding="5">
		  <tr>
		  	<th>��ƷͼƬ</th>
			<th>��Ʒ����</th>
			<th>���ۣ�Ԫ��</th>
			<th>����</th>
			<th>�Ż�</th>
			<th>С�ƣ�Ԫ��</th>
			<th>���ͻ���</th>
			<th>����</th>
		  </tr>
		  <c:forEach var="item" items="${sessionScope.gwc.allItems}">
			  <tr>
				<td align="center" width="60">
					<img src="${pageContext.request.contextPath}/imgsx/${item.smallImg}" />
			    </td>
			    <td align="center" width="60">
					<a href="${pageContext.request.contextPath}/ShowBookInfoServlet?id=${item.bookId}">${item.bookName}</a>
			    </td>
				<td align="center" width="80">
					�� �� ��${item.hyprice}
					<span class="fccc"><del> <br />
					�г��ۣ�${item.price} 
					</del></span>
				</td>
				<td align="center" width="70">${item.num}</td>
				<td align="center" width="50">${(item.price-item.hyprice)*item.num}</td>
				<td align="center" width="60">${item.hyprice*item.num}</td>
				<td align="center" width="30"><span>7</span></td>
				<td align="center" width="100">
					<span class="cols col-7"><a href="#" style="cursor:pointer">�����ղ�</a></span>
				</td>
			  </tr>
		  </c:forEach>
		  <tr><td colspan="8" align="right" class="zongj">
		      �ܼۣ�${sessionScope.gwc.oldPrices}Ԫ -
                              �Żݣ�${sessionScope.gwc.yhPrices}Ԫ
            = ��Ʒ�ܼ�(�����˷�)��<span class="fred">${sessionScope.gwc.hyPrices}Ԫ</span>  ��ã�0 ���ֵ�</td>
		  </tr>
		  
		  <tr><td colspan="8">
		    <div class="left">
		       <a class="btn_clear_cart" href="${pageContext.request.contextPath}/InitIndexServlet"><img src="images/jxgw.png"></a>
               <a class="btn_clear_cart" href="${pageContext.request.contextPath}/ClearGwcItemServlet" onclick="return confirm('��ȷ��Ҫ��չ��ﳵ��?');"><img src="images/qkgw.png"></a>
            </div>
				<div class="right" >
					<input type="image" src="images/tjdd.png">
				</div>
         </td></tr>
		</table>
		</div>
</div>
<div class="footer2" style="margin-left:130px">
��Ȩ���У�www.xubangyiliao.com<br/>
�绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231��
</div>
</form>
</body>
</html>


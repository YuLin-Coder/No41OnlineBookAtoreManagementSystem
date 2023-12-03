<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�����</title>
<meta name="keywords" content="�ؼ���" />
<meta name="description" content="ҳ������" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script type="text/javascript">
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("������������ֵ��");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > ${requestScope.pageCount}) {
    			alert("������ҳ�뷶Χ�ڵ���ֵ��");
    			return;
    		}
    		location = "${pageContext.request.contextPath}/ShowBookListByTypeId?typeId=${param.typeId}&nowPage="+nowPage;
    	}
</script>
</head>
<body>
<!-- top1 -->
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
            	<li><a href="${pageContext.request.contextPath}/gouwuche.jsp"><img src="images/car.gif"/><br />���ﳵ</a></li>
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
<!-- middle -->
<div class="middle">
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	������Ʒ����
            </div>
            <div class="middle_left1con">
            <%@include file="leftBookType.jsp"%>
            </div>
            <div class="zzzz"> </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">��������</h3>
        	<c:forEach var="zxbooks" items="${requestScope.rxbooks}" begin="0" end="9">
        		<a href="${pageContext.request.contextPath}/ShowBookInfoServlet?id=${zxbooks.bookId}">${zxbooks.bookName}</a>
        	</c:forEach>
        </div> 
    </div>
    <div class="middle_right">
      <div class="middle_right6tit">����ǰ��λ�ã���վ��ҳ   ��Ʒ�б�ҳ</div>
		 <div class="middle_right6con">
            <div class="warpbor">
            <c:forEach var="books" items="${requestScope.bookInfos}">
            	<div class="middle_right6con">
              	<div class="warpbor">
                <div class="leftshop"><a href="${pageContext.request.contextPath}/ShowBookInfoServlet?id=${books.bookId}">
                <img src="${pageContext.request.contextPath}/imgsx/${books.smallImg}" width="98" height="160"/></a></div>
                <div class="righttext"><h3>Ŀ�ͣ�${books.author}</h3><p/> 
       				 <span class="fontcc">(50629������)</span><br />
       				  ${books.author}��/${books.pbdate}<br />
       				  ${books.context}
     			   <span class="xiangx">${books.hyprice}<span class="textde">${books.price}</span> �ۿۣ�${books.hyprice / books.price}�� 
     			   <a href="<%=request.getContextPath() %>/AddGwcItemServlet?id=${books.bookId}"><img src="images/btn_buy.gif"/></a>
     			   <a href="#"><img src="images/btn_keep.gif"/></a></span>
     		    </div>
       		  </div>
  			</div>
            </c:forEach>
 		    </div>
  			<div align="center">
			��${requestScope.pageCount}ҳ
  			��${requestScope.nowPage}ҳ
  			<c:if test="${requestScope.nowPage == 1}" var="result">
  				��һҳ ��һҳ
  			</c:if>
  			<c:if test="${!result}">
  				<a href="${pageContext.request.contextPath}/ShowBookListByTypeId?typeId=${param.typeId}&nowPage=1">��һҳ</a>
  				<a href="<%=request.getContextPath()%>/ShowBookListByTypeId?typeId=${param.typeId}&nowPage=${requestScope.nowPage-1}">��һҳ</a>
  			</c:if>
  			<c:if test="${requestScope.nowPage == requestScope.pageCount}" var="result">
  				��һҳ ���ҳ
  			</c:if>
  			<c:if test="${!result}">
  				<a href="${pageContext.request.contextPath}/ShowBookListByTypeId?typeId=${param.typeId}&nowPage=${requestScope.nowPage+1}">��һҳ</a>
  				<a href="${pageContext.request.contextPath}/ShowBookListByTypeId?typeId=${param.typeId}&nowPage=${requestScope.pageCount}">���ҳ</a>	
  			</c:if>
  			<select onchange="gotoNowPage(this.value)">
  				<c:forEach begin="1" end="${requestScope.pageCount}" varStatus="status">
  					<option value="${status.count}"
  						<c:if test="${requestScope.nowPage == status.count}">
  							selected;
  						</c:if>
  		 			>��${status.count}ҳ</option>
  				</c:forEach>
  		 	</select>
  		 	��
  		 	<input size="2" value="${requestScope.nowPage}" onchange="gotoNowPage(this.value)"/>
  		 	ҳ	
		</div>
		<br />
	</div>
</div>
</div>
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
	<a href="http://product.dangdang.com/23690437.html#ddclick?act=click&pos=23690437_0_1_p&cat=01.38.07.00.00.00&key=&qinfo=&pinfo=7023_1_60&minfo=&ninfo=&custid=&permid=20160414103850170642707113084209851&ref=&rcount=&type=&t=1460601593000&searchapi_version=test_new">��˾���</a><span>|</span><a href="#">��������</a><span>|</span><a href="#">��˽����</a><span>|</span><a href="#">��ѯ�ȵ�</a><span>|</span><a href="#">������ļ</a><span>|</span><a href="#">���ͷ�ʽ</a><span>|</span><a href="#">��ϵ����</a>
    </div>
    <div class="footer2">
    @ 2011-2012 ���ҽ���̳� ��Ȩ���У�����������Ȩ����<br />
    �绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231�� ����֧�֣�<a href="#">��������</a>
    </div>
</div>
</body>
</html>

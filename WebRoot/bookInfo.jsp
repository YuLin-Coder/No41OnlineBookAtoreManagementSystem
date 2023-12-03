<%@page language="java" contentType="text/html; charset=gbk"%>
<%@page import="com.bookstore.bean.BookInfo"%>
<%@page import="com.bookstore.bean.BookDiscuss"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
<SCRIPT src="js/jquery-1.2.6.pack.js" type="text/javascript"></SCRIPT>
<SCRIPT src="js/base.js" type="text/javascript"></SCRIPT>

</head>
<body>
<%
	BookInfo bookInfos = (BookInfo)request.getAttribute("bookInfo");
	List<BookInfo> rxbooks = (List<BookInfo>)request.getAttribute("rxbooks");
	List<BookDiscuss> discuss = (List<BookDiscuss>)request.getAttribute("discuss");
%>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登录网上商城！
   	用户名：<input type="text" name="name" value="${sessionScope.customerInfo.custName}" class="inputsty"/> 
   	密码：<input type="password" name="password" value="${sessionScope.customerInfo.pwd}" class="inputsty"/> 
   	<a href="#">忘记密码?</a> 
   	<a href="${pageContext.request.contextPath}/qtLogin.jsp">登录</a>
   	<a href="${pageContext.request.contextPath}/background/index.jsp">注册</a>
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>书名:<input type="text" name="" class="kuang" />  </li>
            	<li>作者:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="<%=request.getContextPath() %>/gouwuche.jsp">
            		<img src="images/car.gif"/><br />购物车</a></li>
				<li><a href="#"><img src="images/car.gif" /><br />订单查询  </a></li>
				<li><a href="#"><img src="images/car.gif" /><br />我的空间</a></li>
				<li><a href="http://book.jd.com/?cu=true&utm_source=baidu-search&utm_medium=cpc&utm_campaign=t_262767352_baidusearch&utm_term=16409889721_0_1139ce8fca7e4ebfb6cb34d7e9d98c17"><img src="images/car.gif" /><br />购书服务 </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="<%=request.getContextPath() %>/InitIndexServlet">首页</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">畅销</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">文学</a></li>
                <li><a href="http://www.dangdang.com/">书系</a></li>
                <li><a href="http://www.dangdang.com/">文化</a></li>
                <li><a href="http://book.jd.com/?cu=true&utm_source=baidu-search&utm_medium=cpc&utm_campaign=t_262767352_baidusearch&utm_term=16409889721_0_1139ce8fca7e4ebfb6cb34d7e9d98c17">经营</a></li>
            </ul>
        </div>
	</div>
</div>
<!-- middle -->
<div class="middle">
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	所有商品分类
            </div>
            <div class="middle_left1con">
               <%@include file="leftBookType.jsp"%>
            </div>
            <div class="zzzz">
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">最新排行</h3>
        	<%for(int i = 0; i < rxbooks.size(); i++){ 
        		BookInfo bookInfo = new BookInfo();
        		bookInfo = rxbooks.get(i);
        	%>
			<a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>"><%=bookInfo.getBookName() %></a>
			<%} %>
        </div> 
    </div>
    <div class="middle_right">
    	<div class="middle_right6tit">
        	您当前的位置：网站首页 --- 产品类别  
        </div>
        <div class="middle_right6con">
    <div id="preview">
            <div class="jqzoom" id="spec-n1" onclick="window.open('http://www.lanrentuku.com/')"><IMG height="350" 
            src="imgsd/<%=bookInfos.getBigImg()%>" jqimg="imgsd/<%=bookInfos.getBigImg() %>" width="350" />
            </div>
            <div id="spec-n5">
                <div class="control" id="spec-left">
                    <img src="images/left.gif" />
                </div>
                <div id="spec-list">
                    <ul class="list-h">
                        <li><img src="imgsd/<%=bookInfos.getBigImg() %>"/> </li>
                    </ul>
                </div>
                <div class="control" id="spec-right">
                    <img src="images/right.gif" />
                </div>
            </div>
        </div>
        <SCRIPT type="text/javascript">
            $(function(){			
               $(".jqzoom").jqueryzoom({
                    xzoom:400,
                    yzoom:400,
                    offset:10,
                    position:"right",
                    preload:1,
                    lens:1
                });
                $("#spec-list").jdMarquee({
                    deriction:"left",
                    width:350,
                    height:56,
                    step:2,
                    speed:4,
                    delay:10,
                    control:true,
                    _front:"#spec-right",
                    _back:"#spec-left"
                });
                $("#spec-list img").bind("mouseover",function(){
                    var src=$(this).attr("src");
                    $("#spec-n1 img").eq(0).attr({
                        src:src.replace("\/n5\/","\/n1\/"),
                        jqimg:src.replace("\/n5\/","\/n0\/")
                    });
                    $(this).css({
                        "border":"2px solid #ff6600",
                        "padding":"1px"
                    });
                }).bind("mouseout",function(){
                    $(this).css({
                        "border":"1px solid #ccc",
                        "padding":"2px"
                    });
                });				
            });
            </SCRIPT>
        <SCRIPT src="js/lib.js" type="text/javascript"></SCRIPT>
        <SCRIPT src="js/163css.js" type="text/javascript"></SCRIPT>

        <div class="middle_rightR">
        <table width="100%" border="0">
          <tr>
            <td>市场价:<%=bookInfos.getPrice() %>元</td>
            <td>商品货:<%=bookInfos.getBookName() %></td>
          </tr>
          <tr>
            <td>会员价：<%=bookInfos.getHyprice() %>元</td>
            <td>库存情况：<%=bookInfos.getNum() %>件</td>
          </tr>
           <tr>
            <td>作者:<%=bookInfos.getAuthor() %></td>
            <td>累计销量:<%=bookInfos.getSaleCount() %></td>
          </tr>
          <tr>
            <td>出版社:<%=bookInfos.getPbName() %></td>
          </tr>
          <tr>
            <td>出版日期:<%=bookInfos.getPbdate() %></td>
          </tr>
          <tr>
            <td>上架日期:<%=bookInfos.getSjdate() %></td>
          </tr>
          <tr>
            <td>所属品牌：文学</td>
            <td>点击次数：123456</td>
          </tr>
          <tr>
            <td colspan="2">商品评论： <img src="images/icon3.jpg" /> (已有<%=discuss.size() %>人评论)</td>
          </tr>
        </table>
        <div class="middle_rightRC"> 我要买
        	<input type="text" name="input" class="kwid" value="1"/>
        <br />
        	已选择：1件		总价:<span class="STYLE1"><%=bookInfos.getHyprice() %></span> 元<br />
 	 	<a href="<%=request.getContextPath() %>/AddGwcItemServlet?id=<%=bookInfos.getBookId() %>">
 	 		<input name="" type="image" src="images/jr.jpg" class="button11"/>
 	 	</a>
        </div>
      </div>
      </div> 	
        <div class="middle8">
        	<div class="middle8tit">
            	<a href="#"><span>产品信息</span></a>
            </div>
            <div class="middle8con" >             
			<%=bookInfos.getContext() %>
        	</div>
        <div class="middle9">
        	<div class="middle9tit">书评:</div>
        		<ul>
        		<c:forEach var="bookDiscuss" items="${requestScope.discuss}">
        			&nbsp;&nbsp;&nbsp;&nbsp;
        			书评编号为${bookDiscuss.custId}的说：${bookDiscuss.context}<br/><br/>
        		</c:forEach>
        		</ul>
        	</div>
        </div>
        <div class="middle9">
        	<div class="middle9tit">用户评论</div>
            <div class="middle_right9con">
            	<div>用户名：匿名用户</div>
                <div>E-mail:<input type="text" name="text" size="25" /></div>
            	<div>评论等级：
            		<input name="" type="radio" value="" /><img src="images/pl1.gif"/> 
            		<input name="" type="radio" value="" /><img src="images/pl1.gif"/> 
            		<input name="" type="radio" value="" /><img src="images/pl1.gif" /> 
            		<input name="" type="radio" value="" /><img src="images/pl1.gif" /> 
            		<input name="" type="radio" value="" /><img src="images/pl1.gif"/></div>
            	<div>评论内容：<textarea name="" cols="" rows=""></textarea></div>
                <div>验证码：<input type="text"  size="15" /><img src="images/yz.gif"/></div>
                <div><input type="button"  class="btn4" value=" " /></div>
            </div>
            </div>        
        </div> 		   
	</div>
	
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
		<a href="#">公司简介</a><span>|</span><a href="#">免责条款</a><span>|</span><a href="#">隐私保护</a><span>|</span>
		<a href="#">咨询热点</a><span>|</span><a href="#">合作招募</a><span>|</span><a href="#">配送方式</a><span>|</span>
		<a href="#">联系我们</a>
    </div>
    <div class="footer2">
    	@ 2011-2012 旭邦医疗商城 版权所有，并保留所有权利。<br />
    	电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号 技术支持：<a href="#">徽韵网络</a>
    </div>
</div>
</body>
</html>


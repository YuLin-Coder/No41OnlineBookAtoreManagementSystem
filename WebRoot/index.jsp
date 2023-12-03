<%@ page language="java" contentType="text/html; charset=gbk" %>
<%@page import="java.util.List" %>
<%@page import="com.bookstore.bean.BookInfo" %>
<%@page import="com.bookstore.bean.News" %>
<%@page import="com.bookstore.bean.BookType" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>�����</title>
    <meta name="keywords" content="�ؼ���"/>
    <meta name="description" content="ҳ������"/>
    <link rel="stylesheet" href="style/public.css" type="text/css"/>
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
    <script src="js/banner.js" type="text/javascript"></script>
</head>
<body>
<%
    List<News> newsList = (List<News>) request.getAttribute("news");
    List<BookInfo> sjbooks = (List<BookInfo>) request.getAttribute("sjbooks");
    List<BookInfo> rxbooks = (List<BookInfo>) request.getAttribute("rxbooks");
    List<BookInfo> tjbooks = (List<BookInfo>) request.getAttribute("tjbooks");
%>

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
                <li>����:<input type="text" value="" class="kuang"/></li>
                <li>����:<input type="text" value="" class="kuang"/></li>
                <li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
            </ul>
        </div>
        <div class="top1_2_r">
            <ul class="other">
                <li>
                    <a href="<%=request.getContextPath() %>/gouwuche.jsp">
                        <img src="images/car.gif"/><br/>���ﳵ</a>
                </li>
                <li><a href="#"><img src="images/car.gif"/><br/>������ѯ </a></li>
                <li><a href="#"><img src="images/car.gif"/><br/>�ҵĿռ�</a></li>
                <li>
                    <a href="http://book.jd.com/?cu=true&utm_source=baidu-search&utm_medium=cpc&utm_campaign=t_262767352_baidusearch&utm_term=16409889721_0_1139ce8fca7e4ebfb6cb34d7e9d98c17"><img
                            src="images/car.gif"/><br/>������� </a></li>
            </ul>
            <ul class="menu">
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">��ҳ</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">����</a></li>
                <li><a href="<%=request.getContextPath() %>/InitIndexServlet">��ѧ</a></li>
                <li><a href="http://www.dangdang.com/">��ϵ</a></li>
                <li><a href="http://www.dangdang.com/">�Ļ�</a></li>
                <li>
                    <a href="http://book.jd.com/?cu=true&utm_source=baidu-search&utm_medium=cpc&utm_campaign=t_262767352_baidusearch&utm_term=16409889721_0_1139ce8fca7e4ebfb6cb34d7e9d98c17">��Ӫ</a>
                </li>
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
                <%@include file="leftBookType.jsp" %>
            </div>
        </div>
        <div class="middle_left3">
            <h3 class="paihtit">��������</h3>
            <%
                for (int i = 0; i < rxbooks.size(); i++) {
                    BookInfo bookInfo = new BookInfo();
                    bookInfo = rxbooks.get(i);
            %>
            <a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>"><%=bookInfo.getBookName() %>
            </a>
            <%} %>
        </div>
        <div class="middle_left2">
            <img src="images/01.jpg"/>
        </div>
        <div class="middle_left2">
            <img src="images/05.jpg"/>
        </div>
        <div class="middle_left2">
            <img src="images/1.jpg"/>
        </div>
        <div class="middle_left2">
            <img src="images/2.jpg"/>
        </div>
        <div class="middle_left2">
            <img src="images/3.jpg"/>
        </div>
    </div>

    <div class="middle_right">
        <div class="middle_right1L">
            <DIV id="idContainer2" class="container">
                <TABLE id="idSlider2" border="0" cellspacing="0" cellpadding="0">
                    <TBODY>
                    <TR>
                        <TD class="td_f"><A href="#"><IMG src="images/01.jpg"/></A></TD>
                        <TD class="td_f"><A href="#"><IMG src="images/02.jpg"/></A></TD>
                        <TD class="td_f"><A href="#"><IMG src="images/03.jpg"/></A></TD>
                        <TD class="td_f"><A href="#"><IMG src="images/04.jpg"/></A></TD>
                        <TD class="td_f"><A href="#"><IMG src="images/05.jpg"/></A></TD>
                    </TR>
                    </TBODY>
                </TABLE>
                <UL id="idNum" class="num"></UL>
            </DIV>
            <SCRIPT>
                var forEach = function (array, callback, thisObject) {
                    if (array.forEach) {
                        array.forEach(callback, thisObject);
                    } else {
                        for (var i = 0, len = array.length; i < len; i++) {
                            callback.call(thisObject, array[i], i, array);
                        }
                    }
                };

                var st = new SlideTrans("idContainer2", "idSlider2", 5, {Vertical: false});

                var nums = [];
                //��������
                for (var i = 0, n = st._count - 1; i <= n;) {
                    (nums[i] = $("idNum").appendChild(document.createElement("li"))).innerHTML = ++i;
                }

                forEach(nums, function (o, i) {
                    o.onmouseover = function () {
                        o.className = "on";
                        st.Auto = false;
                        st.Run(i);
                    };
                    o.onmouseout = function () {
                        o.className = "";
                        st.Auto = true;
                        st.Run();
                    };
                });

                //���ð�ť��ʽ
                st.onStart = function () {
                    forEach(nums, function (o, i) {
                        o.className = st.Index == i ? "on" : "";
                    });
                };
                st.Run();
            </SCRIPT>
        </div>
        <div class="middle_right1R">
            <div class="middle_right1Rtitle"></div>
            <div class="middle_right1Rcon">
                <ul>
                    <%
                        for (int i = 0; i < newsList.size(); i++) {
                            News news = new News();
                            news = newsList.get(i);
                    %>
                    <li>
                        <a href="<%=request.getContextPath() %>/ShowNewsServlet?id=<%=news.getNewsId() %>"><%=news.getNewTitle() %>
                        </a></li>
                    <%} %>
                </ul>
            </div>
            <div class="middle_right1Rimg">
                <img src="images/middle_right1Rimg.jpg"/>
            </div>
        </div>
        <div class="middle_right2">
            <div class="middle_right2Rtitle">������Ʒ <i>New book</i></div>
            <div class="middle_right2Rcon">
                <ul>
                    <%
                        for (int i = 0; i < sjbooks.size(); i++) {
                            BookInfo bookInfo = sjbooks.get(i);
                    %>
                    <li><a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                        <img src="imgsx/<%=bookInfo.getSmallImg() %>" width="95"
                             height="180"/><br/><%=bookInfo.getBookName() %>
                    </a>
                        <br/>
                        <span class="borline">�г��ۣ���<%=bookInfo.getPrice() %></span>
                        <br/><span>�̳Ǽۣ���<%=bookInfo.getHyprice() %></span>
                        <a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                            <img src="<%=request.getContextPath()%>/images/btn3.gif"
                                 width="90" height="25"/></a></li>
                    <%} %>
                </ul>
            </div>
        </div>
        <div class="middle_right2">
            <div class="middle_right2Rtitle title2">������Ʒ <i>hot book</i></div>
            <div class="middle_right2Rcon">
                <ul>
                    <%
                        for (int i = 0; i < rxbooks.size(); i++) {
                            BookInfo bookInfo = new BookInfo();
                            bookInfo = rxbooks.get(i);
                    %>
                    <li><a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                        <img src="imgsx/<%=bookInfo.getSmallImg() %>" width="95"
                             height="180"/><br/><%=bookInfo.getBookName() %>
                    </a>
                        <br/>
                        <span class="borline">�г��ۣ���<%=bookInfo.getPrice() %></span>
                        <br/><span>�̳Ǽۣ���<%=bookInfo.getHyprice() %></span>
                        <a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                            <img src="<%=request.getContextPath()%>/images/btn3.gif"
                                 width="90" height="25"/></a></li>
                    <%} %>
                </ul>
            </div>
        </div>
        <div class="middle_right3">
            <div class="middle_right3Rtitle title3"></div>
            <div class="middle_right3Rcon">
                <ul>
                    <%
                        for (int i = 0; i < tjbooks.size(); i++) {
                            BookInfo bookInfo = new BookInfo();
                            bookInfo = tjbooks.get(i);
                    %>
                    <li><a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                        <img src="imgsx/<%=bookInfo.getSmallImg() %>" width="95"
                             height="180"/><br/><%=bookInfo.getBookName() %>
                    </a>
                        <br/>
                        <span class="borline">�г��ۣ���<%=bookInfo.getPrice() %></span>
                        <br/><span>�̳Ǽۣ���<%=bookInfo.getHyprice() %></span>
                        <a href="<%=request.getContextPath() %>/ShowBookInfoServlet?id=<%=bookInfo.getBookId() %>">
                            <img src="<%=request.getContextPath()%>/images/btn3.gif"
                                 width="90" height="25"/></a></li>
                    <%} %>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clear"><img src="#" width="1" height="1"/></div>
<!-- footer -->
<div class="footer">
    <ul class="lbox">
        <li>
            <a href="http://book.jd.com/?cu=true&utm_source=baidu-search&utm_medium=cpc&utm_campaign=t_262767352_baidusearch&utm_term=16409889721_0_1139ce8fca7e4ebfb6cb34d7e9d98c17">�˿ͱض�</a>
        </li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
    <ul class="lbox">
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
    <ul class="lbox">
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
    <ul class="lbox nolbox">
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
</div>
<!-- footer1 -->
<div class="footer1">
    <img src="images/footer1img.jpg"/>
    <img src="images/footer2img.jpg"/>
    <img src="images/footer3img.jpg"/>
    <img src="images/footer4img.jpg"/>
    <img src="images/footer5img.jpg"/>
    <img src="images/footer6img.jpg"/>
</div>
<!-- footer2 -->
<div class="footer2">
    ��Ȩ���У�www.xubangyiliao.com<br/>
    �绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231��
</div>
</body>
</html>

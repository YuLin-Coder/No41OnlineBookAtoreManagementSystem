var zongfen = -3;
//点评页 星星鼠标移入
function selstar(id) {
    var dis = "点击左边的星星";
    jQuery("#starli").removeClass();
    switch (id) {
        case -1: dis = "1分，很差"; jQuery("#starli").addClass("one"); break;
        case 0: dis = "2分，勉强"; jQuery("#starli").addClass("two"); break;
        case 1: dis = "3分，一般"; jQuery("#starli").addClass("three"); break;
        case 2: dis = "4分，好"; jQuery("#starli").addClass("four"); break;
        case 3: dis = "5分，很好"; jQuery("#starli").addClass("five"); break;
    }

    jQuery("#disstar").html(dis).css("color", "green");
}
//点评页 星星鼠标移出
function outstar() {
    if (zongfen != -3) {
        selstar(zongfen);
    }
    else {
        jQuery("#starli").removeClass();
        jQuery("#disstar").html("点击星星打分").css("color", "gray");
    }
}
//点评页 星星点击
function clickstar(fen) {
    zongfen = fen;
}
function styleyqd() {
    var target = document.getElementById("dkd1");
    target.style.background = "";
    target.style.border = "1px solid white";
    var me = document.getElementById("dkd2");
    me.style.background = "none repeat scroll 0 0 #FFFFE6";
    me.style.border = "1px solid #F5D174";
}
function stylezj() {
    var target = document.getElementById("dkd2");
    target.style.background = "";
    target.style.border = "1px solid white";
    var me = document.getElementById("dkd1");
    me.style.background = "none repeat scroll 0 0 #FFFFE6";
    me.style.border = "1px solid #F5D174";
}
//点评页 优缺点总结文本框点击样式改变
function textclick(objid, typeid) {
    bianse('dpyd');
    bianse('dpqd');
    bianse('dpzj');

    if (typeid == '1') {
        styleyqd();
    }
    else {
        stylezj();
    }

    var meobj = jQuery("#" + objid);
    if (meobj.val() == '您对产品满意的地方' || meobj.val() == '产品还需要改进的地方' || meobj.val() == '您对产品各个方面的总评价') {
        meobj.val("");
        meobj.css("color", "black");
    }

    jQuery("#zfid").css("border", "1px solid white");
    jQuery("#zfid").css("background", "");
}
//点评页 优缺点总结文本框内容颜色改变
function bianse(obj) {
    var txt = jQuery('#' + obj).val();
    if (txt == '您对产品满意的地方' || txt == '产品还需要改进的地方' || txt == '您对产品各个方面的总评价') {
        jQuery('#' + obj).css('color', 'gray');
    }
    else {
        jQuery('#' + obj).css('color', 'black');
    }
}
//公共
function jisuan(obj) {
    var par = jQuery('#hudong'); // .find('#'+obj).val();
    var len = 0;
    var dts;
    var count = 1500;
    var clen = 0;

    if (obj == '1') {
        dts = jQuery("#dts");
        var dpyd = par.find('#dpyd').val();
        if (dpyd == '您对产品满意的地方') dpyd = '';

        if (dpyd == '您对产品满意的地方' || dpyd == '') {
            jQuery("div[name='dpyd']").css("h83");
        } else {
            jQuery("div[name='dpyd']").css("h83_1");
        }

        var dpqd = par.find('#dpqd').val();
        if (dpqd == '产品还需要改进的地方') dpqd = '';

        if (dpqd == '产品还需要改进的地方' || dpqd == '') {
            jQuery("div[name='dpqd']").css("h83");
        } else {
            jQuery("div[name='dpqd']").css("h83_1");
        }

        len = getNumberLen(dpyd) + getNumberLen(dpqd);

        len = len / 2;
    }
    else {
        if (dpzj == '' || dpzj == '您对产品各个方面的总评价') {
            jQuery("div[name='dpzj']").css("h83");
        } else {
            jQuery("div[name='dpzj']").css("h83_1");
        }
        count = 500;
        dts = jQuery("#dtszj");
        len = getNumberLen(par.find('#dpzj').val());
        len = len / 2;
    }

    if (len < 10) {
        if (len < 0.5) {
            dts.html("<span style='color:red;'>请输入文字，纯数字无法提交！</span>");
        }
        else {
            dts.html("<span style='color:red;'>您还需要输入" + (10 - parseInt(len)) + "个字</span>")
        }
    }
    else {
        if (obj == '1') {
            clen = getlen(dpyd) + getlen(dpqd);
        }
        else {
            clen = getlen(par.find('#dpzj').val());
        }

        if (clen > count * 2) {
            dts.html("<span style='color:red;'>您输入的字数量过长，不能提交！</span>");
        }
        else {
            dts.html("<span style='color:black;'>您还可以输入</span> <span style='color:#10AB51;'>" + parseInt(count - clen / 2) + "</span> <span style='color:black;'>个字</span>");
        }
    }
}
//公共 获取字符串的长度
function getlen(str) {
    var len = str.length;
    var count = 0;

    for (var i = 0; i < len; i++) {
        if (str.charCodeAt(i) > 126 || str.charCodeAt(i) < 27) {
            count = count + 2;
        }
        else {
            count++;
        }
    }
    count = parseInt(count);
    return count;
}
//公共
function getNumberLen(str) {
    str = str.replace(/　/g, "").replace(/\n/g, "");
    var len = str.length;
    var count = 0;

    for (var i = 0; i < len; i++) {
        if ((str.charCodeAt(i) > 63 && str.charCodeAt(i) < 91) || (str.charCodeAt(i) > 96 && str.charCodeAt(i) < 123)) {
            count++;
        }
        if (str.charCodeAt(i) > 126 || str.charCodeAt(i) < 27) {
            count = count + 2;
        }

    }
    return count;
}

function shuruyd() {
    var target = document.getElementById("dkd1");
    target.style.background = "";
    target.style.border = "1px solid white";
    var me = document.getElementById("dkd2");
    me.style.background = "none repeat scroll 0 0 #FFFFE6";
    me.style.border = "1px solid #F5D174";

    var meobj = jQuery("#dpyd");
    if (meobj.val() == '您对产品满意的地方' || meobj.val() == '产品还需要改进的地方') {
        meobj.val("");
        meobj.css("color", "black");
    }
    if (jQuery("#dpyd").val() == "" || jQuery("#dpqd").val() == "") {
        alert("请填写优点或不足！");
    }

    jQuery("#dpyd").focus();
}
function shuruzj() {
    var target = document.getElementById("dkd2");
    target.style.background = "";
    target.style.border = "1px solid white";
    var me = document.getElementById("dkd1");
    me.style.background = "none repeat scroll 0 0 #FFFFE6";
    me.style.border = "1px solid #F5D174";
    var meobj = jQuery("#dpzj");
    if (meobj.val() == '您对产品各个方面的总评价') {
        meobj.val("");
        meobj.css("color", "black");
    }
    if (jQuery("#dpzj").val() == "") {
        alert("请填写总结！");
    }
    jQuery("#dpzj").focus();
}
//点评
function nbtnsubmit() {

    //更新回调地址
    var reffer = window.location.href;
    jQuery("#ComReffer").val(reffer);

    //更新用户信息
    var BC = CommonJS.readCookie('pu_cookie');
    if (BC == null) {
        var BC = CommonJS.readCookie('bu_cookie');
    }
    if (BC != null) {
        var BC_Info = [];
        BC_Info = BC.split("|");
        jQuery("#ComUserId").val(BC_Info[0]);
        jQuery("#ComUserName").val(BC_Info[1]);
    }

    jQuery("#CommentVirtue").val("");
    jQuery("#CommentDefect").val("");
    jQuery("#CommentSummarize").val("");

    //验证并更新评分
    if (zongfen == -3) {
        window.location = '#SendComment';
        jQuery("#zfid").css("border", "1px solid red");
        jQuery("#zfid").css("background", "none repeat scroll 0 0 #FFFFE6");
        jQuery('#disstar').css('color', 'red');
        alert("请您点击星星打分！");
        return;
    }
    jQuery("#Commend").val(zongfen);

    //验证并更新评论内容
    textclick("dpzj", 2);
    var txtqd = jQuery("#dpqd").val();
    var txtyd = jQuery("#dpyd").val();
    var txtzj = jQuery("#dpzj").val();
    var errormsg = "优点、不足至少填写一项！";
    var ts = jQuery("#dts");

    if (txtyd == '您对产品满意的地方' && txtqd == '产品还需要改进的地方') {
        ts.html(errormsg);
        ts.css("color", "red");
        shuruyd();
        return;
    }

    if (txtyd == '您对产品满意的地方') { txtyd = ''; }
    if (txtqd == '产品还需要改进的地方') { txtqd = ''; }

    if (getNumberLen(txtyd) < 1 && txtyd != '') {
        ts.html("请输入文字，纯数字无法提交！");
        ts.css("color", "red");
        shuruyd();
        jQuery('#dpyd').focus();
        return;
    }
    if (getNumberLen(txtqd) < 1 && txtqd != '') {
        ts.html("请输入文字，纯数字无法提交！");
        ts.css("color", "red");
        shuruyd();
        jQuery('#dpqd').focus();
        return;
    }

    var len = getNumberLen(txtyd) + getNumberLen(txtqd);
    len = len / 2;

    if (len < 10) {
        ts.html(errormsg + "您还需要输入 " + (10 - parseInt(len)) + " 个字！");
        ts.css("color", "red");
        shuruyd();
        return;
    }
    len = getlen(txtyd) + getlen(txtqd);
    if (len > 3000) {
        ts.html("优点、不足的输入总字数不能超过1500字！");
        ts.css("color", "red");
        shuruyd();
        return;
    }

    errormsg = "总结为必填！";
    if (txtzj == "您对产品各个方面的总评价") txtzj = "";
    len = getNumberLen(txtzj);
    len = len / 2;
    var dts = jQuery("#dtszj");

    if (txtzj == '您对产品各个方面的总评价') {
        dts.html(errormsg + "您还需要输入 " + (10 - parseInt(len)) + " 个字！");
        dts.css("color", "red");
        shuruzj();
        return;
    }
    if (len < 10) {
        dts.html(errormsg + "您还需要输入 " + (10 - parseInt(len)) + " 个字！");
        dts.css("color", "red");
        shuruzj();
        return;
    }
    len = getlen(txtzj);
    if (len > 1000) {
        dts.html("总结的输入总字数不能超过500字！");
        dts.css("color", "red");
        shuruzj();
        return;
    }

    if (txtyd != '您对产品满意的地方') {
        jQuery("#CommentVirtue").val(txtyd);
    }
    if (txtqd != '产品还需要改进的地方') {
        jQuery("#CommentDefect").val(txtqd);
    }
    jQuery("#CommentSummarize").val(txtzj);

    //同步微博
    if (jQuery("#CommentWeio").attr("checked") == true) {
        //F_ProductLongName是在aspx中定义的
        $.ajax({ url: "/AjaxDataOperate/SendWeibo.aspx", type: 'POST', data: { 'name': escape(F_ProductLongName), 'content': escape(txtzj), 'link': reffer, 'UserIP': UserIP }, dataType: "html", success: function(data) {
            var html = data.toString();
            //alert(html);
        }
        });
    }

    //提交点评
    document.forms["CommentForm"].submit();
}

//验证点评回复内容 并提交
function SubmitCommentReply(CommentID) {
    //更新用户信息
    var BC = CommonJS.readCookie('pu_cookie');
    if (BC == null) {
        var BC = CommonJS.readCookie('bu_cookie');
    }
    if (BC != null) {
        var BC_Info = [];
        BC_Info = BC.split("|");
        jQuery("#ReplyUserId").val(BC_Info[0]);
        jQuery("#ReplyUserName").val(BC_Info[1]);
    }

    //更新回调地址
    var reffer = jQuery("#RestoreLogin_" + CommentID).attr("reffer");
    jQuery("#ReplyReffer").val(reffer);

    //更新被回复的点评ID
    jQuery("#RestoreCommentId").val(CommentID);

    //验证并且更新评论恢复内容
    var spandiv = jQuery("#ReplyMsg_" + CommentID);
    var textdiv = jQuery("#ReplyInfo_" + CommentID);
    var ncontent = textdiv.val();
    var len = getlen(ncontent);
    var reffer = jQuery("#RestoreLogin_" + CommentID).attr("reffer");
    if (ncontent == "请勿发表与本文无关的留言或是恶意攻击其他用户。") {
        spandiv.html("请输入评论内容！");
        spandiv.css("color", "red");
        return;
    }
    if (len < 1) {
        spandiv.html("请输入评论内容！");
        spandiv.css("color", "red");
        textdiv.focus();
        return;
    }
    if (len > 1000) {
        spandiv.html("评论内容不能超过500个汉字！");
        spandiv.css("color", "red");
        textdiv.focus();
        return;
    }
    jQuery("#CommentContent").val(ncontent);

    //同步微博
    if (jQuery("#CommentWeio_" + CommentID).attr("checked") == true) {
        //F_ProductLongName是在aspx中定义的
        $.ajax({ url: "/AjaxDataOperate/SendWeibo.aspx", type: 'POST', data: { 'name': escape(F_ProductLongName), 'content': escape(ncontent), 'link': reffer, 'UserIP': UserIP }, dataType: "html", success: function(data) {
            var html = data.toString();
            //alert(html);
        }
        });
    }

    //提交点评
    document.forms["CommentReplyForm"].submit();
}

document.onkeydown = function(event) {

    e = event ? event : (window.event ? window.event : null);

    if (e.keyCode == 9) {
        var dpyd = document.getElementById("dpyd");
        var dpqd = document.getElementById("dpqd");
        var dpzj = document.getElementById("dpzj");

        if (isActiveElement(dpyd)) {
            dpqd.select();
            styleyqd();
            jQuery('#dpqd').css("color", "black");
            dpsd('dpyd');
            e.returnValue = false;
            return false;
        }
        if (isActiveElement(dpqd)) {
            dpzj.select();
            stylezj();
            jQuery('#dpzj').css("color", "black");
            dpsd('dpqd');
            e.returnValue = false;
            return false;
        }
        if (isActiveElement(dpzj)) {
            dpyd.select();
            styleyqd();
            jQuery('#dpyd').css("color", "black");
            dpsd('dpzj');
            e.returnValue = false;
            return false;
        }
    }
}

function dpsd(objid) {
    var meobj = jQuery("#" + objid);
    if (meobj.val() == '您对产品满意的地方' || meobj.val() == '产品还需要改进的地方' || meobj.val() == '您对产品各个方面的总评价') {
        meobj.css("color", "gray");
    }
    else {
        meobj.css("color", "black");
    }
}

function isActiveElement(obj) {
    return obj == document.activeElement;
}
jQuery(document).click(function() {

    try {
        var d1 = document.getElementById("dpyd");
        var d2 = document.getElementById("dpqd");
        var d3 = document.getElementById("dpzj");
        if (isActiveElement(d1) || isActiveElement(d2) || isActiveElement(d3)) {
            return;
        }

        var target = document.getElementById("dkd1");
        target.style.background = "";
        target.style.border = "1px solid white";

        target = document.getElementById("dkd2");
        target.style.background = "";
        target.style.border = "1px solid white";

    } catch (ex) { }
});

function submitEyes(ButtonControl, AvailOrNotAvail, CommentID, IndexID) {
    var parent = jQuery(ButtonControl).parent();
    jQuery(ButtonControl).parent().find("input").attr("disabled", "disabled");
    var url;
    if (AvailOrNotAvail != 0) {
        url = "http://dianping.it168.com/popComment/ChangeNotAvailCount?jsoncallback=?";
    }
    else {
        url = "http://dianping.pcpop.com/popComment/ChangeAvailCount?jsoncallback=?";
    }
    jQuery.getJSON(url, { CommentID: CommentID, indexID: IndexID, net4: Math.random() }, function(val) {
        if (val.Count == 1) {
            //提交成功
            parent.find("b").each(function(i) {
                if (i == AvailOrNotAvail) {
                    var count = parseInt(jQuery(this).html()) + 1;
                    jQuery(this).html("" + count);
                }
                if (i == 2) {
                    jQuery(this).html("您已投过票，谢谢！！！");
                }
            })
        }
        else {
            //禁止提交
            parent.find("b").each(function(i) {
                if (i == 2) {
                    jQuery(this).html("您已投过票，谢谢！！");
                }
            })
        }
    });
}


//只有点评页调用
//自动加载 评论框随内容增多而变化高度
jQuery(function() {
    readyOnLoad("#dpzj");
    readyOnLoad("#dpqd");
    readyOnLoad("#dpyd");
});
function readyOnLoad(obj) {
    jQuery(obj).css("overflow-y", "hidden");
    jQuery(obj).keydown(function() { textareaautoheight(this) });
    jQuery(obj).keyup(function() { textareaautoheight(this) });
}
function textareaautoheight(obj) {
    if (obj == null) { return; }
    jQuery(obj).css("height", '83px');
    if (obj.scrollHeight >= 83) {
        jQuery(obj).css("height", (obj.scrollHeight + 4) + 'px');
    }
}

var newComment = {
    //页面是否第一次加载
    isFrist: true,
    //加载评论内容
    setProductComment: function(CurrentPage, F_ProductSN, F_SeriesSN, F_BrandSN) {
        var url = RootUrl + "AjaxDataOperate/ProductComment.aspx?CurrentPage=" + CurrentPage + "&F_ProductSN=" + F_ProductSN + "&F_SeriesSN=" + F_SeriesSN + "&F_BrandSN=" + F_BrandSN;
        $.ajax({ url: url, success: function(data) {
            var html = data.toString();
            $("#proComList").remove();
            $("#proComPage").remove();
            $("#SendComment").before(html);
            document.location.hash = "#proCom";
            document.location.hash = "#" + CurrentPage + "_" + F_ProductSN + "_" + F_SeriesSN + "_" + F_BrandSN;

            if (this.isFrist) {//第一次进入页面时不执行pv,只有生成页面后的js调用时才执行
                this.isFrist = false;
            } else {
                if (top.location == self.location) {
                    window.setTimeout("sendPV()", 500);
                }
            }
        }
        });
    },
    //加载地址栏初始化
    showProductComment: function() {
        //设置或获取 href 属性中在井号“#”后面的分段。
        var pars = window.location.hash.replace('#', '').split('_');
        if (pars.length == 4) {
            this.setProductComment(pars[0], pars[1], pars[2], pars[3]);
        }
    },
    //单条点评回复框的展示
    RestoreLoginShow: function(CommentID) {
        if ($("#RestoreLogin_" + CommentID).html() != "") {
            $("#RestoreLogin_" + CommentID).html("");
        } else {
            var returnurl = window.location.href;

            var html = "";
            html += "<div class=\"pinglun\">";
            html += "<div class=\"dot0426\"></div>";
            html += "<div class=\"login0426\">";

            var BC = CommonJS.readCookie('pu_cookie');
            if (BC == null) {
                var BC = CommonJS.readCookie('bu_cookie');
            }
            if (BC != null) {
                //分析cookie获取用户昵称
                var BC_Info = BC.split("|"); //local cookie
                var LUN = CommonJS.URLdecode(BC_Info[1]);

                html += "欢迎您，" + LUN + " | <a href=\"http://uc.pcpop.com/uc_quit.php?returnurl=" + returnurl + "\"  target=\"_self\">退出</a>";
            } else {
//                html += "<span><span style=\"float:left;\">使用合作账号登录：</span><a class=\"qq\" href=\"http://uc.pcpop.com/suc/api/qq/login.php?t=1&returnurl=" + returnurl + "\"  target=\"_self\">&nbsp;&nbsp;&nbsp;</a></span>";
                html += "<a href=\"http://uc.pcpop.com/uc_login.php?returnurl=" + returnurl + "\" target=\"_self\">登录</a> | ";
                html += "<a href=\"http://uc.pcpop.com/uc_register.php?returnurl=" + returnurl + "\"  target=\"_self\">注册</a>";
            }
            html += "</div>";

            html += "<div class=\"form0426\">";
            html += "<textarea class=\"text0426\" id=\"ReplyInfo_" + CommentID + "\" onclick=\"newComment.RestoreClick('" + CommentID + "')\" onkeyup=\"newComment.ChangeCommentReply('" + CommentID + "')\" onblur=\"newComment.RestoreOnblur('" + CommentID + "')\">";
            html += "请勿发表与本文无关的留言或是恶意攻击其他用户。</textarea>";
            html += "<div class=\"h26\">";
            html += "<span id=\"ReplyMsg_" + CommentID + "\" style=\"color: green;float: left;\"></span>";
            html += "<input type=\"submit\" class=\"btn0426\" onclick=\"SubmitCommentReply('" + CommentID + "')\" target=\"_self\" value=\"发表评论\">";
            if (newComment.ShowWeibo() == true) {
//                html += "<div style=\"float:right;padding-top:8px;\">";
//                html += "<input id=\"CommentWeio_" + CommentID + "\" type=\"checkbox\" />同步微博&nbsp;&nbsp;";
//                html += "</div>";
            }
            html += "</div>";
            html += "</div>";
            html += "</div>";
            $("#RestoreLogin_" + CommentID).html(html);
        }
    },
    //点评回复框选中效果
    RestoreClick: function(CommentID) {
        var meobj = jQuery("#ReplyInfo_" + CommentID);
        if (meobj.val() == "请勿发表与本文无关的留言或是恶意攻击其他用户。") {

            meobj.val("");
            meobj.css("color", "black");
        }
    },
    RestoreOnblur: function(CommentID) {
        var meobj = jQuery("#ReplyInfo_" + CommentID);
        if (meobj.val() == "") {
            meobj.val("请勿发表与本文无关的留言或是恶意攻击其他用户。");
            meobj.css("color", "#ccc");
            jQuery("#ReplyMsg_" + CommentID).html("");
        }
    },
    dpydOnblur: function() {
        //优点
        var dpyd = jQuery("#dpyd");
        if (dpyd.val() == "") {
            dpyd.val("您对产品满意的地方");
            dpyd.css("color", "gray");
            var dpqd = jQuery("#dpqd");
            if (dpqd.val() == '产品还需要改进的地方') {
                jQuery("#dts span").html("");
            }
        }
    },
    dpqdOnblur: function() {
        //缺点
        var dpqd = jQuery("#dpqd");
        if (dpqd.val() == "") {
            dpqd.val("产品还需要改进的地方");
            dpqd.css("color", "gray");

            var dpyd = jQuery("#dpyd");
            if (dpyd.val() == "您对产品满意的地方") {
                jQuery("#dts span").html("");
            }
        }
    },
    dpzjOnblur: function() {
        //总结
        var dpzj = jQuery("#dpzj");
        if (dpzj.val() == '') {
            dpzj.val("您对产品各个方面的总评价");
            dpzj.css("color", "gray");

            jQuery("#dtszj span").html("");
        }
    },
    //验证点评回复内容
    ChangeCommentReply: function(CommentID) {
        var ncontent = jQuery("#ReplyInfo_" + CommentID).val();
        var len = getNumberLen(ncontent);
        len = len / 2;
        var clen = getlen(ncontent);

        var spandiv = jQuery("#ReplyMsg_" + CommentID);
        if (len < 0.5) {
            spandiv.css("color", "red");
            spandiv.html("请输入文字，纯数字无法提交！");
            return;
        }
        if (clen > 1000 || len > 500) {
            spandiv.css("color", "red");
            spandiv.html("评论内容不能超过500个字！");
            return;
        }
        else {
            spandiv.css("color", "green");
            spandiv.html("您还可以输入 " + (500 - (Math.round(clen / 2))) + " 个字！");
            return;
        }
    },
    //显示用户信息（评论页）
    //ssoUN  登录账号|绑定站点用户UID|站点ID
    //pu_cookie,bu_cookie UC的ID|用户昵称|升级状态
    ShowLogin: function() {
        //判断用户的登录状态
        var BC = CommonJS.readCookie('pu_cookie');
        if (BC == null) {
            var BC = CommonJS.readCookie('bu_cookie');
        }
        if (BC != null) {
            //分析cookie获取用户昵称
            var BC_Info = BC.split("|");
            var LUN = CommonJS.URLdecode(BC_Info[1]);

            //展示用户信息
            jQuery("#UserName").html("欢迎您，" + LUN);
            jQuery("#isNoLogin").hide();
            jQuery("#isLogin").show();
            jQuery("#isLoginQQ").hide();

            //判断是否应该展示同步微博
            if (newComment.ShowWeibo() == true) {
                jQuery("#CommentWeibo").show();
            }
        }
    },
    //点评的微博是否显示
    ShowWeibo: function() {
        var UN = CommonJS.readCookie('ssoUN');
        if (UN != null) {
            var UN_Info = UN.split("|");
            var state = UN_Info[3];
            if (state != null) {
                return true;
            }
        }
        return false;
    }
}
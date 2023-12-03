/**
 * 返回日期
 * @param d the delimiter
 * @param p the pattern of your date
 */
document.write('<div id="calendarBase" style="position: absolute;visibility: hidden;z-index: 9999;background-color: #FFFFFF;border: 1px solid #CCCCCC;width:175px;font-size:12px;"><iFrame id="baseFrame"></iFrame></div>');
document.write('<div id="calendarPanel" style="position: absolute;visibility: hidden;z-index: 9999;background-color: #FFFFFF;border: 1px solid #CCCCCC;width:175px;font-size:12px;"></div>');
String.prototype.toDate = function(x, p) {
  if(x == null) x = "-";
  if(p == null) p = "ymd";
  var a = this.split(x);
  var y = parseInt(a[p.indexOf("y")]);
  //remember to change this next century ;)
  if(y.toString().length <= 2) y += 2000;
  if(isNaN(y)) y = new Date().getFullYear();
  var m = parseInt(a[p.indexOf("m")]) - 1;
  var d = parseInt(a[p.indexOf("d")]);
  if(isNaN(d)) d = 1;
  return new Date(y, m, d);
};

/**
 * 格式化日期

 * @param   d the delimiter
 * @param   p the pattern of your date
 */
Date.prototype.format = function(style) {
  var o = {
    "M+" : this.getMonth() + 1, //month
    "d+" : this.getDate(),      //day
    "h+" : this.getHours(),     //hour
    "m+" : this.getMinutes(),   //minute
    "s+" : this.getSeconds(),   //second
    "w+" : "天一二三四五六".charAt(this.getDay()),   //week
    "q+" : Math.floor((this.getMonth() + 3) / 3),  //quarter;
    "S"  : this.getMilliseconds(), //millisecond
  };
  if(/(y+)/.test(style)) {
    style = style.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(style)){
    	style = style.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    };
  }
  return style;
};

/**
 * 日历类

 * @param   beginYear 1945
 * @param   endYear   2020
 * @param   lang      0(中文)|1(英语) 可自由扩充

 * @param   dateFormatStyle  "yyyy-MM-dd";
 * @version 2006-04-01
 * @update
 */
function Calendar(beginYear, endYear, lang, dateFormatStyle) {
  this.beginYear = 1945;
  this.endYear = 2020;
  this.lang = 0;            //0(中文) | 1(英文)
  this.dateFormatStyle = "yyyy-MM-dd";

  if (beginYear != null && endYear != null){
    this.beginYear = beginYear;
    this.endYear = endYear;
  }
  if (lang != null){
    this.lang = lang;
  }

  if (dateFormatStyle != null){
    this.dateFormatStyle = dateFormatStyle;
  }

  this.dateControl = null;
  this.panel = this.getElementById("calendarPanel");
  this.base = this.getElementById("calendarBase");
  this.baseIframe = this.getElementById("baseFrame");
  this.form  = null;

  this.date = new Date();
  this.year = this.date.getFullYear();
  this.month = this.date.getMonth();


  this.colors = {
  "cur_word"      : "#FFFFFF",  //当日日期文字颜色
  "cur_bg"        : "#00FF00",  //当日日期单元格背影色
  "choosed_bg"    : "#97FFFF",  //已设定日期单元格背影色

  "sun_word"      : "#FF0000",  //星期天文字颜色

  "sat_word"      : "#0000FF",  //星期六文字颜色

  "td_word_light" : "#333333",  //单元格文字颜色

  "td_word_dark"  : "#CCCCCC",  //单元格文字暗色

  "td_bg_out"     : "#EFEFEF",  //单元格背影色
  "td_bg_over"    : "#FFCC00",  //单元格背影色
  "tr_word"       : "#FFFFFF",  //日历头文字颜色

  "tr_bg"         : "#666666",  //日历头背影色
  "input_border"  : "#CCCCCC",  //input控件的边框颜色

  "input_bg"      : "#EFEFEF"   //input控件的背影色
  };

  this.draw();
  this.bindYear();
  this.bindMonth();
  this.changeSelect();
  this.bindData();
}

/**
 * 日历类属性（语言包，可自由扩展）
 */
Calendar.language = {
  "year"   : [[""], [""]],
  "months" : [["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
        ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"]
         ],
  "weeks"  : [["日","一","二","三","四","五","六"],
        ["SUN","MON","TUR","WED","THU","FRI","SAT"]
         ],
  "clear"  : [["清空"], ["CLS"]],
  "today"  : [["今天"], ["TODAY"]],
  "close"  : [["关闭"], ["CLOSE"]]
};

Calendar.prototype.draw = function() {
  calendar = this;

  var mvAry = [];
  mvAry[mvAry.length]  = '  <form name="calendarForm" style="margin: 0px;">';
  mvAry[mvAry.length]  = '    <table width="100%" border="0" cellpadding="0" cellspacing="1">';
  mvAry[mvAry.length]  = '      <tr>';
  mvAry[mvAry.length]  = '        <th align="left" width="1%"><input style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:16px;height:20px;" name="prevMonth" type="button" id="prevMonth" value="&lt;" /></th>';
  mvAry[mvAry.length]  = '        <th align="center" width="98%" nowrap="nowrap"><select name="calendarYear" id="calendarYear" style="font-size:12px;"></select><select name="calendarMonth" id="calendarMonth" style="font-size:12px;"></select></th>';
  mvAry[mvAry.length]  = '        <th align="right" width="1%"><input style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:16px;height:20px;" name="nextMonth" type="button" id="nextMonth" value="&gt;" /></th>';
  mvAry[mvAry.length]  = '      </tr>';
  mvAry[mvAry.length]  = '    </table>';
  mvAry[mvAry.length]  = '    <table id="calendarTable" width="100%" style="border:0px solid #CCCCCC;background-color:#FFFFFF" border="0" cellpadding="3" cellspacing="1">';
  mvAry[mvAry.length]  = '      <tr>';
  for(var i = 0; i < 7; i++) {
    mvAry[mvAry.length]  = '      <th style="font-weight:normal;background-color:' + calendar.colors["tr_bg"] + ';color:' + calendar.colors["tr_word"] + ';">' + Calendar.language["weeks"][this.lang][i] + '</th>';
  }
  mvAry[mvAry.length]  = '      </tr>';
  for(var i = 0; i < 6;i++){
    mvAry[mvAry.length]  = '    <tr align="center">';
    for(var j = 0; j < 7; j++) {
      if (j == 0){
        mvAry[mvAry.length]  = '  <td style="cursor:default;color:' + calendar.colors["sun_word"] + ';"></td>';
      } else if(j == 6) {
        mvAry[mvAry.length]  = '  <td style="cursor:default;color:' + calendar.colors["sat_word"] + ';"></td>';
      } else {
        mvAry[mvAry.length]  = '  <td style="cursor:default;"></td>';
      };
    }
    mvAry[mvAry.length]  = '    </tr>';
  }
  mvAry[mvAry.length]  = '      <tr style="background-color:' + calendar.colors["input_bg"] + ';">';
  mvAry[mvAry.length]  = '        <th colspan="2"><input name="calendarClear" type="button" id="calendarClear" value="' + Calendar.language["clear"][this.lang] + '" style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:100%;height:20px;font-size:12px;"/></th>';
  mvAry[mvAry.length]  = '        <th colspan="3"><input name="calendarToday" type="button" id="calendarToday" value="' + Calendar.language["today"][this.lang] + '" style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:100%;height:20px;font-size:12px;"/></th>';
  mvAry[mvAry.length]  = '        <th colspan="2"><input name="calendarClose" type="button" id="calendarClose" value="' + Calendar.language["close"][this.lang] + '" style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:100%;height:20px;font-size:12px;"/></th>';
  mvAry[mvAry.length]  = '      </tr>';
  mvAry[mvAry.length]  = '    </table>';
  mvAry[mvAry.length]  = '  </form>';
  this.panel.innerHTML = mvAry.join("");
  this.form = document.forms["calendarForm"];

  this.form.prevMonth.onclick = function () {calendar.goPrevMonth(this);};
  this.form.nextMonth.onclick = function () {calendar.goNextMonth(this);};

  this.form.calendarClear.onclick = function () {calendar.dateControl.value = "";calendar.hide();};
  this.form.calendarClose.onclick = function () {calendar.hide();};
  this.form.calendarYear.onchange = function () {calendar.update(this);};
  this.form.calendarMonth.onchange = function () {calendar.update(this);};
  this.form.calendarToday.onclick = function () {
    var today = new Date();
    calendar.date = today;
    calendar.year = today.getFullYear();
    calendar.month = today.getMonth();
    calendar.changeSelect();
    calendar.bindData();
    calendar.dateControl.value = today.format(calendar.dateFormatStyle);
    calendar.hide();
  };
};

//年份下拉框绑定数据

Calendar.prototype.bindYear = function() {
  var cy = this.form.calendarYear;
  cy.length = 0;
  for (var i = this.beginYear; i <= this.endYear; i++){
    cy.options[cy.length] = new Option(i + Calendar.language["year"][this.lang], i);
  };
};

//月份下拉框绑定数据

Calendar.prototype.bindMonth = function() {
  var cm = this.form.calendarMonth;
  cm.length = 0;
  for (var i = 0; i < 12; i++){
    cm.options[cm.length] = new Option(Calendar.language["months"][this.lang][i], i);
  };
};

//向前一月

Calendar.prototype.goPrevMonth = function(e){
  if (this.year == this.beginYear && this.month == 0){return;}
  this.month--;
  if (this.month == -1) {
    this.year--;
    this.month = 11;
  }
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect();
  this.bindData();
};

//向后一月
Calendar.prototype.goNextMonth = function(e){
  if (this.year == this.endYear && this.month == 11){return;}
  this.month++;
  if (this.month == 12) {
    this.year++;
    this.month = 0;
  }
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect();
  this.bindData();
};

//改变SELECT选中状态

Calendar.prototype.changeSelect = function() {
  var cy = this.form.calendarYear;
  var cm = this.form.calendarMonth;
  for (var i= 0; i < cy.length; i++){
    if (cy.options[i].value == this.date.getFullYear()){
      cy[i].selected = true;
      break;
    };
  }
  for (var i= 0; i < cm.length; i++){
    if (cm.options[i].value == this.date.getMonth()){
      cm[i].selected = true;
      break;
    };
  };
};

//更新年、月
Calendar.prototype.update = function (e){
  this.year  = e.form.calendarYear.options[e.form.calendarYear.selectedIndex].value;
  this.month = e.form.calendarMonth.options[e.form.calendarMonth.selectedIndex].value;
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect();
  this.bindData();
};

//绑定数据到月视图
Calendar.prototype.bindData = function () {
  var calendar = this;
  var dateArray = this.getMonthViewArray(this.date.getYear(), this.date.getMonth());
  var tds = this.getElementById("calendarTable").getElementsByTagName("td");
  for(var i = 0; i < tds.length; i++) {
  tds[i].style.backgroundColor = calendar.colors["td_bg_out"];
    tds[i].onclick = function () {return;};
    tds[i].onmouseover = function () {return;};
    tds[i].onmouseout = function () {return;};
    if (i > dateArray.length - 1) break;
    tds[i].innerHTML = dateArray[i];
    if (dateArray[i] != "&nbsp;"){
      tds[i].onclick = function () {
        if (calendar.dateControl != null){
          calendar.dateControl.value = new Date(calendar.date.getFullYear(),
                                                calendar.date.getMonth(),
                                                this.innerHTML).format(calendar.dateFormatStyle);
        }
        calendar.hide();
      };
      tds[i].onmouseover = function () {
        this.style.backgroundColor = calendar.colors["td_bg_over"];
      };
      tds[i].onmouseout = function () {
        this.style.backgroundColor = calendar.colors["td_bg_out"];
      };
      if (this.date.format(calendar.dateFormatStyle) ==
          new Date(calendar.date.getFullYear(),
                   calendar.date.getMonth(),
                   dateArray[i]).format(calendar.dateFormatStyle)) {
        tds[i].style.backgroundColor = calendar.colors["choosed_bg"];
        tds[i].onmouseover = function () {
          this.style.backgroundColor = calendar.colors["td_bg_over"];
        };
        tds[i].onmouseout = function () {
          this.style.backgroundColor = calendar.colors["choosed_bg"];
        };
      }
      if (new Date().format(calendar.dateFormatStyle) ==
          new Date(calendar.date.getFullYear(),
                   calendar.date.getMonth(),
                   dateArray[i]).format(calendar.dateFormatStyle)) {
        tds[i].style.backgroundColor = calendar.colors["cur_bg"];
        tds[i].onmouseover = function () {
          this.style.backgroundColor = calendar.colors["td_bg_over"];
        };
        tds[i].onmouseout = function () {
          this.style.backgroundColor = calendar.colors["cur_bg"];
        };
      };
    };
  };
};

//根据年、月得到月视图数据(数组形式)
Calendar.prototype.getMonthViewArray = function (y, m) {
  var mvArray = [];
  var dayOfFirstDay = new Date(y, m, 1).getDay();
  var daysOfMonth = new Date(y, m + 1, 0).getDate();
  for (var i = 0; i < 42; i++) {
    mvArray[i] = "&nbsp;";
  }
  for (var i = 0; i < daysOfMonth; i++){
    mvArray[i + dayOfFirstDay] = i + 1;
  }
  return mvArray;
};

//扩展 document.getElementById(id) 多浏览器兼容性 from meizz tree source
Calendar.prototype.getElementById = function(id){
  if (typeof(id) != "string" || id == "") return null;
  if (document.getElementById) return document.getElementById(id);
  if (document.all) return document.all(id);
  try {return eval(id);} catch(e){ return null;};
};

//扩展 object.getElementsByTagName(tagName)
Calendar.prototype.getElementsByTagName = function(object, tagName){
  if (document.getElementsByTagName) return document.getElementsByTagName(tagName);
  if (document.all) return document.all.tags(tagName);
};

//取得HTML控件绝对位置
Calendar.prototype.getAbsPoint = function (e){
  var x = e.offsetLeft;
  var y = e.offsetTop;
  while(e = e.offsetParent){
    x += e.offsetLeft;
    y += e.offsetTop;
  }
  return {"x": x, "y": y,};
};

//显示日历
Calendar.prototype.show = function (dateControl, popControl) {
  if (dateControl == null){
    throw new Error("arguments[0] is necessary");
  }
  this.dateControl = dateControl;
  
  //根据当前输入框的日期显示日历的年月
  var reg = /^(\d+)-(\d{1,2})-(\d{1,2})$/; 
  var r = dateControl.value.match(reg); 
  if(r!=null){  
	  r[2]=r[2]-1; 
	  this.date = new Date(r[1], r[2],r[3]);
	  this.year = this.date.getFullYear();
	  this.month = this.date.getMonth();
      this.changeSelect();
      this.bindData();
  }
  if (popControl == null){
    popControl = dateControl;
  }
  var xy = this.getAbsPoint(popControl);
  this.panel.style.left = xy.x + "px";
  this.panel.style.top = (xy.y + dateControl.offsetHeight) + "px";

  this.showBase();
  
  this.panel.style.visibility = "visible";
  
};

//显示底层
Calendar.prototype.showBase = function(){
	    
	// 设置层的相关属性

	this.base.style.visibility="";

	// 定义层的样式
	this.base.style.position="absolute";
	this.base.style.left=this.panel.style.left;
	this.base.style.top=this.panel.style.top;
	this.base.style.width=this.panel.style.width;
	this.base.style.height=this.panel.style.height;
	this.base.style.border="black 1px solid";
	this.base.style.backgroundColor="white";
	
	// 生成iframe
	var L=this.baseIframe;
	L.name="completionFrame";
	
	// 定义iframe的样式，宽高与s相同
	L.width=this.base.style.width;
	L.height=this.base.style.height;
};

//隐藏日历
Calendar.prototype.hide = function() {
  this.base.style.visibility = "hidden";
  this.panel.style.visibility = "hidden";
};
var calenday = new Calendar();
//调用new Calendar.show(dateControl, popControl);

//通过setday()方法显示控件
function setday(obj){
 new Calendar().show(obj);
};

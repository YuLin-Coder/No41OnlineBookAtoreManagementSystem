 function allView (method){ //调用方法
		if(arguments.length>2)						
		{
		  method(arguments[1],arguments[2]);
		}else if(arguments.length>1)
		{
		  method(arguments[1]);
		}
		else
		{	
		  method();
		}
}
 function shopActivityView (method){ //调用方法
		  method(arguments);
}
 var bgObj,msgObj;
 function bgTag(sWidth,sHeight,backcolor,opacity) //参数宽,高,背景色,透明度
{
	var sWidth, sHeight;
	sWidth = document.body.clientWidth;
	sHeight = document.body.clientHeight;
	bgObj = document.createElement("div");
	bgObj.setAttribute("id", "bgDiv");
	bgObj.style.position = "absolute";
	bgObj.style.top = "0";
	bgObj.style.background = backcolor;
	bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity="+opacity+",finishOpacity=75)";
	bgObj.style.opacity = "0.6";
	bgObj.style.left = "0";
	bgObj.style.width = sWidth + "px";
	bgObj.style.height = sHeight + "px";
	bgObj.style.zIndex = "30000";
	document.body.appendChild(bgObj);
	
}
function msgTag(msgw,msgh,backcolor,bordersize,bordercolor)//参数宽,高,背景色,边框粗细,边框颜色
{
  msgObj = document.createElement("div");
	 msgObj.setAttribute("id", "msgDiv");
	 msgObj.setAttribute("align", "center");
	msgObj.style.background = backcolor;
    msgObj.style.border = bordersize+"px solid " + bordercolor;
	msgObj.style.position = "absolute";
	msgObj.style.left = "50%";
	msgObj.style.top = "50%";
	msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	msgObj.style.marginLeft = "-225px";
	msgObj.style.marginTop = -75 + document.documentElement.scrollTop + "px";
	msgObj.style.width = msgw + "px";
	msgObj.style.height = msgh + "px";
	msgObj.style.textAlign = "center";
	msgObj.style.lineHeight = "25px";
	msgObj.style.zIndex = "30001";
}

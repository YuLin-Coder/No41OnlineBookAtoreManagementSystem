	function cookie(){
		var a_id=_getUrlValue("a_id");
		var b_id=_getUrlValue("b_id");
		var eu_id=_getUrlValue("eu_id");
		var cid=_getUrlValue("cid");
		var wid=_getUrlValue("wid");
		var fbt=_getUrlValue("fbt");
		var yid=_getUrlValue('yid');
		var keyword=_getUrlValue('keyword');
		var cookieName;
		var cookieValue; 
		var encoding=getBrowerEncoding();
		if(a_id!=''&&b_id!=''){
			cookieName='EqifaInfo';
			cookieValue=a_id+"|"+"b_id"+"|||"+eu_id;
			saveCookie(cookieName,cookieValue);
		}
		if(cid!=''&&wid!=''){
			cookieName='yiqifaInfo';
			cookieValue=cid+'|'+wid+'|||'+fbt+"_"+_getURI();
			saveCookie("encoding",encoding);
			saveCookie(cookieName, encodingV(cookieValue,encoding));
		}
		if(yid!=''){
			cookieName='YiqifaKeyword';
			cookieValue='_yid_'+yid+'_'+keyword+"_"+_getURI();
			saveCookie("encoding",encoding);
			saveCookie(cookieName,encodingV(cookieValue,encoding));
		}
	
	}
	
	function encodingV(value,encoding){
		return "utf-8"==encoding ?  encodeURIComponent(value) : value;
	}
	
	function getBrowerEncoding(){
		if(navigator.userAgent.indexOf('Opera') >= 0||navigator.userAgent.indexOf('Firefox') >= 0){
			return "gbk";
		}else{
			return "utf-8";
		}
	}
	
	function _getURI(){
		var href=location.href;
		var domain=window.document.domain;
		var s=href.replace("http://"+domain+"/","");
		if(s.indexOf("?")>=0){
			s=s.substring(0,s.indexOf("?"));
		}
		if(s.indexOf("&")>=0){
			s=s.substring(0,s.indexOf("&"));
		}
		return s;
	}
	function _getUrlValue(qs){
	    var s = location.href;
	    s = s.replace("?","?&").split("&");
	    var re = "";
	    for(i=0;i<s.length;i++){
	       if(s[i].indexOf(qs+"=")==0){
	         re = s[i].replace(qs+"=","");
	         break;
	        }
	    }
	    return re;
	}
	function saveCookie(cookieName,cookieValue){
		var name=cookieName;
		var value=cookieValue;
		var expires=1;
		var path="/";
		var domain=".egou.com";
		var secure="";
		var today = new Date();    
	  	today.setTime( today.getTime() );    
	   	if (expires) {     
	       expires = expires * 1000 * 60 * 30;     
	   	}
	    var expires_date = new Date( today.getTime() + (expires));   
	    document.cookie = name+'='+(value)+((expires) ? ';expires='+expires_date.toGMTString() : '')+((path) ? ';path=' + path : '') +((domain) ? ';domain=' + domain : '')+((secure) ? ';secure' : ''); 
	}
	function cleanCookie(cookieName){
		var name=cookieName;
		var value=1;
		var expires=-10000;
		var path="/";
		var domain=".egou.com";
		var secure="";
		var today = new Date();    
	  	today.setTime(today.getTime());    
	    var expires_date = new Date(today.getTime() + (expires)); 
	    document.cookie = name+'='+(value)+((expires) ? ';expires='+expires_date.toGMTString() : '')+((path) ? ';path=' + path : '') +((domain) ? ';domain=' + domain : '')+((secure) ? ';secure' : ''); 
	}
	window.onload=function(){
		//cleanCookie('yiqifaInfo');
		//cleanCookie('YiqifaKeyword');
		cookie();
	}
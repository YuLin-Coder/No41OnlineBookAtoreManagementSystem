jQuery(document).ready(function() {
	var targetObjs = jQuery.grep(jQuery("a[href^='http://']"), function(cur, i){
		return (jQuery(cur).attr("href").indexOf("egou.com") == -1);
	});
	
	var excludeObjs = jQuery("div[nolink='true'] a");
	
	targetObjs = jQuery(targetObjs).not(excludeObjs);
	
	if(targetObjs){
		jQuery.each(targetObjs, function(i, obj){
			jQuery(obj).attr("href", " http://fanxian.egou.com/productredirect.do?sid=0&link="+encodeURIComponent(jQuery(obj).attr("href"))+"");
		});
	}
});

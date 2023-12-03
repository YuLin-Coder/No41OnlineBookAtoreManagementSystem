window.setGrade = function(){
	var ec = $(this);
	if(ec.attr("count") == 0)return;
	var grade = Math.round(ec.attr("grade") / 2) / 10;
	var intPart = parseInt(grade);
	var i = 0;
	for(++i; i <= intPart; ++i) {
		ec.append('<img src="/images/x_7.gif" height="12" />');
	}
	if(intPart < 5){
		if((grade * 10) % 10 < 5) {//²»¹»°ë¸ö
			ec.append('<img src="/images/x_8.gif" height="12" />');
		} else {//¹»°ë¸ö
			ec.append('<img src="/images/x_9.gif" height="12" />');
		}
	}
	for(++i; i < 6; ++i)
		ec.append('<img src="/images/x_8.gif" height="12" />');
};

$(document).ready(function(){
	$(".c_r_2_t div[grade]").each(setGrade);
});
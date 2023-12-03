function cbselect(){
	var cb = document.getElementsByName("cb");
	for(var i=0;i<cb.length;i++){
		if(cb[i].checked==false){
			cb[i].checked=true;
		}else{
			cb[i].checked=false;
		}
	}
}
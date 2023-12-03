var StringLength = function(){
	varsion = "1.0.0";
	author = "houyefeng";
}
StringLength.prototype = {
	getRealLength : function(v){
		var str = this.trim(v);
		if(str == null || str.length == 0) {
			return 0;
		}
		var realLength = 0;
		var c;
		for(var i = 0; i < str.length; i++) {
			if( i == str.length -1) {
				c = str.substring(i);
			} else {
				c = str.substring(i, i+1);
			}
			if(this.isChinese(c)) {
					realLength += 2;
			} else {
				realLength++;
			}
		}
		return realLength;
	},
	isChinese : function (c) {
		return 128 < c.substring(0,1).charCodeAt(0);
	},
	trim : function(str){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
}
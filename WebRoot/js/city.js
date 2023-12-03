	var xhr;
	function changeProvince(opt){
		if(opt.value==""){
			return;
		}
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = execute1;
		var url = "LoadCityServlet?id="+opt.value;
		xhr.open("post",url,true);
		xhr.send(null);
	}
	
	function execute1() {
		document.getElementById("city").length = 1;
		document.getElementById("district").length = 1;
		if(xhr.readyState == 4 && xhr.status == 200) {
			var res = xhr.responseText;
			var shi = res.split("|");
			for(var i = 0; i < shi.length - 1; i++) {
				var s = shi[i];
				var ss = s.split(",");
				var id = ss[0];
				var name = ss[1];
				var opt = document.createElement("option");
				opt.innerHTML = name;
				opt.value = id;
				document.getElementById("city").appendChild(opt);
			}
		}	
	}
	
	function changeCity(opt) {
		if(opt.value==""){
			return;
		}
		xhr.onreadystatechange = execute2;
		var url2 = "LoadDistrictServlet?id="+opt.value;
		xhr.open("post",url2,true);
		xhr.send(null);
	}
	
	function execute2() {
		document.getElementById("district").length = 1;
		if(xhr.readyState == 4 && xhr.status == 200) {
			var res = xhr.responseText;
			var qu = res.split("|");
			for(var i = 0; i < qu.length - 1; i++) {
				var q = qu[i];
				var qq = q.split(",");
				var id = qq[0];
				var name = qq[1];
				var opt = document.createElement("option");
				opt.innerHTML = name;
				opt.value = id;
				document.getElementById("district").appendChild(opt);
			}
		}	
	}
	
	
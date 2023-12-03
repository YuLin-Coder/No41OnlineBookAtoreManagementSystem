function getHttpRequest() {
	var xmlreq = false;
	if (window.XMLHttpRequest) {
		xmlreq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
		  xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
		  try {
		    xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
		  } catch (e2) {
		     xmlreq = false;
		  }
		}
	}
	return xmlreq;
}
function showCity(nameCN,uri){
	if('0'!=nameCN){
		var req = getHttpRequest();
		if(req ){
			req.onreadystatechange = getCitys(req);
			var url = uri+'?nameCN='+nameCN;
			req.open("POST",url,true );
				req.send(null);
		}
	}
}
function getCitys(req){
	return function(){
		if (req.readyState == 4) {
			if (req.status == 200) {
				var xmlDoc=req.responseXML.getElementsByTagName("city");
	            var select_root=document.getElementById('city');
	            select_root.options.length=0;
	            var opt1 = new Option('选择城市','');
	            select_root.options.add(opt1, 0);
	            for(var i=0;i< xmlDoc.length;i++)
	            {
	                var xText=xmlDoc[i].childNodes[0].firstChild.nodeValue;
	                var xValue=xmlDoc[i].childNodes[1].firstChild.nodeValue;
	                var value=xText+","+xValue;	                
	                var option=new Option(xText,value);
	                try{
	                    select_root.options.add(option, i+1);
	                }catch(e){
	                }
	            }
			}
		}
	};
}
function ShowArticle(url, contextPath){
	if(''!=url ){
		var req = getHttpRequest();
		if(req ){
			req.onreadystatechange = ShowArticles(req, contextPath);
			req.open("POST",url,true );
			req.send(null);
		}
	}
}

function ShowArticles(req, contextPath){
	return function(){
		if (req.readyState == 4) {
			if(req.status == 200){
				var xmlDoc=req.responseXML.getElementsByTagName("article");
				var articleContent = document.getElementById('articleContent');
				//var trLength = articleContent.getElementsByTagName("tr").length;
				var tr = '';
				var i=0;
				var row = 0;
				for(i=0;i< xmlDoc.length;i++){
					var tdIndex = i%4;
					
					if(0 == tdIndex) {
						tr = articleContent.insertRow(row++);
					}
					
					var td = tr.insertCell(tdIndex);
					
					var divName = document.createElement("div");
					divName.className = "size_img_1_b";
					var articleId = xmlDoc[i].childNodes[0].firstChild.nodeValue;
					divName.innerHTML = "<a href=\""+contextPath+"/articleCommentBeginList.do?articleId="+articleId+"\" target=\"_blank\">"+xmlDoc[i].childNodes[1].firstChild.nodeValue+"</a>";
					
					var divPrice = document.createElement("div");
					divPrice.className = "size_img_1_b";
					var priceSpan = document.createElement("span");
					priceSpan.className = "color_1";
					
					var price = "￥" + xmlDoc[i].childNodes[2].firstChild.nodeValue;
					priceSpan.innerHTML = price;
					divPrice.appendChild(priceSpan);
					
					var divImage = document.createElement("div");
					divImage.className = "size_img_1_a";
					var imageUrl = xmlDoc[i].childNodes[3].firstChild.nodeValue;
					if('null'==imageUrl) 
						divImage.innerHTML = "<img src='"+contextPath+"/images/front/articledefault.png' class='size_img' width='80' height='111' />";
					else{
						divImage.innerHTML = "<a target=\"_blank\" href=\""+contextPath+"/articleCommentBeginList.do?articleId="+articleId+"\">"
											 +"<img src='"+imageUrl + "' class='size_img' width='80' height='111' /></a>"; 
					}
					var tdDiv = document.createElement("div");
					tdDiv.className = "size_img_1";
					tdDiv.appendChild(divImage);
					tdDiv.appendChild(divName);
					tdDiv.appendChild(divPrice);
					
					td.appendChild(tdDiv);
				}
				if(0!=i%4){
					var emptyTdNum = 4-(i%4)+1;
					for(var j=(i%4); j<emptyTdNum; j++){
						var emptyTd = tr.insertCell(j);
						emptyTd.innnerHTML='&nbsp;';
					}
				}
				var articleMore = document.getElementById('articleMore');
				if(xmlDoc.length>0){
					articleMore.style.display='';
				}else{
					tr = articleContent.insertRow(row);				
					var tdMore = tr.insertCell(0);
					tdMore.height=30;
					tdMore.align = "center";
					tdMore.innerHTML = "暂无内容！";
					articleMore.style.display='none';
				}
			}
		}
	};
}

function ShowThread(userId){
	if( ''!=userId && ''!=userId ){
		var req = getHttpRequest();
		if(req ){
			var url = "http://bbs.egou.com/mythread.php?num=20&uid=" + userId;
			req.onreadystatechange = ShowArticles(req);
			req.open("GET",url,true );
			req.send(null);
		}
	}
}	
function CreateThreadList(req){
	return function(){
		if (req.readyState == 4) {
			if(req.status == 200){
				var xmlDoc=req.responseXML.getElementsByTagName("thread");
				var threadContent = document.getElementById('threadContent');
				var content = "<ul>";
				for(var i=0; i<xmlDoc.length; i++){
					var subject = xmlDoc[i].childNodes[0].firstChild.nodeValue;
					//var tid = xmlDoc[i].childNodes[1].firstChild.nodeValue;
					content += "<li><a href=\"#\" target=\"_blank\">"+subject+"</a></li>";
				}
				content += "</ul>";
				threadContent.innerHTML = content;
			}	
		}
	};
}
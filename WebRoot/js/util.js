function do_resize() {
	if (opener) {
		var w = mainTable.clientWidth - document.body.clientWidth + document.body.clientLeft;
		var h = mainTable.clientHeight - document.body.clientHeight + document.body.clientTop;
		window.resizeBy(w, 0);
		window.resizeBy(0, h);
	}
}
function open_input_form(url, title) {
	window.open(url, title, "width=600,height=400,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1");
}
function open_select_form(url, title, element) {
	window.src_element = element;
	window.open(url, title, "width=460,height=280,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1");
}
function checkSingleSelect(check_me) {
	if (isMultiSelect) {
		return;
	}
	if (check_me.checked == false) {
		return;
	}
	var inp = document.all.tags("INPUT");
	for (var i = 0; i < inp.length; i++) {
		if (inp[i].type == "checkbox" && inp[i] != check_me) {
			if (inp[i].checked) {
				inp[i].checked = false;
				return;
			}
		}
	}
}
function checkbox_init(key) {
	var A = key.split(",");
	var inp = document.all.tags("INPUT");
	for (var i = 0; i < inp.length; i++) {
		if (inp[i].type == "checkbox") {
			var id = inp[i].value;
			for (var j = 0; j < A.length; j++) {
				if (id == A[j]) {
					inp[i].checked = true;
				}
			}
		}
	}
}
function document_loaded() {
	if (document.all.bnDelete) {
		document.all.bnDelete.onclick = delete_confirm;
	}
	if (opener && opener.src_element) {
		if (opener.src_element.value != "") {
			var A = opener.src_element.value.split(",");
			var inp = document.all.tags("INPUT");
			for (var i = 0; i < inp.length; i++) {
				if (inp[i].type == "checkbox") {
					var id = inp[i].name.substring(4);
					for (var j = 0; j < A.length; j++) {
						if (id == A[j]) {
							inp[i].checked = true;
						}
					}
				}
			}
		}
	}
}
function add_element(A, key) {
	var exist = false;
	for (var i = 0; i < A.length; i++) {
		if (A[i] == key) {
			exist = true;
			break;
		}
	}
	if (!exist) {
		A[A.length] = key;
	}
}
function remove_element(A, key) {
	var B = new Array();
	for (var i = 0; i < A.length; i++) {
		if (A[i] != key) {
			B[B.length] = A[i];
		}
	}
	return B;
}
function select_save() {
	if (opener && opener.src_element) {
		var A = new Array();
		if (isMultiSelect && opener.src_element.value != "") {
			A = opener.src_element.value.split(",");
		}
		var inp = document.all.tags("INPUT");
		for (var i = 0; i < inp.length; i++) {
			if (inp[i].type == "checkbox") {
				var id = inp[i].value;
				if (inp[i].checked) {
					add_element(A, id);
				} else {
					A = remove_element(A, id);
				}
			}
		}
		opener.src_element.value = A.join(",");
	}
	//self.close();
}
function xmlEncode(value) {
	var A = new Array();
	A = value.split("&");
	str = A.join("&amp;");
	A = str.split("<");
	str = A.join("&lt;");
	A = str.split(">");
	str = A.join("&gt;");
	A = str.split("\"");
	str = A.join("&quot;");
	A = str.split("'");
	str = A.join("&apos;");
	return str;
}
function getSingleControlValue(obj) {
	if (obj.tagName == "INPUT" && obj.type == "checkbox") {
		if (obj.checked == true) {
			obj.value = "Y";
		} else {
			obj.value = "N";
		}
	}
	return obj.value;
}
function getControlValue(obj) {
	if (obj != null) {
		if (obj.tagName) {
			return getSingleControlValue(obj);
		} else {
			if (obj.length) {
				for (var i = 0; i < obj.length; i++) {
					if (obj[i].tagName == "INPUT") {
						if (obj[i].type == "radio") {
							if (obj[i].checked) {
								return obj[i].value;
							}
						} else {
							if (obj[i].type == "checkbox") {
								if (obj[i].checked) {
									return obj[i].value;
								}
							}
						}
					}
				}
			}
		}
	}
}
function getXML(obj, tag) {
	var strXml = "";
	if (obj != null) {
		var v = getControlValue(obj);
		if (v != null && v != "") {
			strXml = "<" + tag + ">";
			strXml += xmlEncode(v);
			strXml += "</" + tag + ">";
		}
	}
	return strXml;
}
function getBooleanXML(obj, tag) {
	var strXml = "";
	if (obj != null) {
		var v = getControlValue(obj);
		strXml = "<" + tag + ">";
		strXml += (v == "Y") ? "true" : "false";
		strXml += "</" + tag + ">";
	}
	return strXml;
}
function getDateXML(obj, tag) {
}
function getDetailXML(obj, tag, tag2) {
	var strXml = "";
	if (obj != null) {
		if (obj.tagName) {
			if (obj.value != "") {
				var keys = new Array();
				keys = obj.value.split(",");
				for (var i = 0; i < keys.length; i++) {
					strXml += "<" + tag + "><" + tag2 + ">" + keys[i] + "</" + tag2 + "></" + tag + ">";
				}
			}
		} else {
			if (obj.length) {
				for (var j = 0; j < obj.length; j++) {
					if (obj[j].tagName == "INPUT") {
						if (obj[j].type == "checkbox") {
							if (obj[j].checked) {
								strXml += "<" + tag + "><" + tag2 + ">" + obj[j].value + "</" + tag2 + "></" + tag + ">";
							}
						}
					}
				}
			}
		}
	}
	return strXml;
}
function input_form_init(f, query) {
	var A = new Array();
	A = query.split("&");
	for (var i = 0; i < A.length; i++) {
		if (A[i].charAt(0) == "_") {
			var index = A[i].indexOf("=");
			if (index != -1) {
				var ename = A[i].substring(0, index);
				var e = f[ename];
				if (e != null) {
					var v = A[i].substring(index + 1);
					if (e.tagName == "SELECT") {
						var opts = e.options;
						for (var j = 0; j < opts.length; j++) {
							if (v == opts[j].value) {
								opts[j].selected = true;
								break;
							}
						}
					} else {
						e.value = v;
					}
					e.disabled = true;
				}
			}
		}
	}
}
function setOrderBy(f, n) {
	if (f.orderby.value == n) {
		f.orderby.value += " DESC";
	} else {
		f.orderby.value = n;
	}
	f.submit();
	return false;
}
function disableAll() {
	var a = document.getElementsByTagName("input");
	if (a) {
		for (var i = 0; i < a.length; i++) {
			if (a[i].type == "button") {
				a[i].disabled = true;
			}
		}
	}
	return true;
}

function utf8(wide) {
	var c, s;
	var enc = "";
	var i = 0;
	while (i < wide.length) {
		c = wide.charCodeAt(i++);
    // handle UTF-16 surrogates
		if (c >= 56320 && c < 57344) {
			continue;
		}
		if (c >= 55296 && c < 56320) {
			if (i >= wide.length) {
				continue;
			}
			s = wide.charCodeAt(i++);
			if (s < 56320 || c >= 56832) {
				continue;
			}
			c = ((c - 55296) << 10) + (s - 56320) + 65536;
		}
    // output value
		if (c < 128) {
			enc += String.fromCharCode(c);
		} else {
			if (c < 2048) {
				enc += String.fromCharCode(192 + (c >> 6), 128 + (c & 63));
			} else {
				if (c < 65536) {
					enc += String.fromCharCode(224 + (c >> 12), 128 + (c >> 6 & 63), 128 + (c & 63));
				} else {
					enc += String.fromCharCode(240 + (c >> 18), 128 + (c >> 12 & 63), 128 + (c >> 6 & 63), 128 + (c & 63));
				}
			}
		}
	}
	return enc;
}
var hexchars = "0123456789ABCDEF";
function toHex(n) {
	return hexchars.charAt(n >> 4) + hexchars.charAt(n & 15);
}
var okURIchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
function encodeURIComponentNew(s) {
	var s = utf8(s);
	var c;
	var enc = "";
	for (var i = 0; i < s.length; i++) {
		if (okURIchars.indexOf(s.charAt(i)) == -1) {
			enc += "%" + toHex(s.charCodeAt(i));
		} else {
			enc += s.charAt(i);
		}
	}
	return enc;
}
function URLEncode(fld) {
	if (fld == "") {
		return false;
	}
	var encodedField = "";
	var s = fld;
	if (typeof encodeURIComponent == "function") {
  // Use javascript built-in function
  // IE 5.5+ and Netscape 6+ and Mozilla
		encodedField = encodeURIComponent(s);
	} else {
  // Need to mimic the javascript version
  // Netscape 4 and IE 4 and IE 5.0
		encodedField = encodeURIComponentNew(s);
	}
 //alert ("New encoding: " + encodeURIComponentNew(fld) +
 //  "n           escape(): " + escape(fld));
	return encodedField;
}

function copy_clip(copy, msg) {
	if (window.clipboardData) {
		window.clipboardData.setData("Text", copy);
	} else {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			}
			catch (e) {
				alert("!!\xb1\xbb\xe4\xaf\xc0\xc0\xc6\xf7\xbe\xdc\xbe\xf8\xa3\xa1\n\xc7\xeb\xd4\xda\xe4\xaf\xc0\xc0\xc6\xf7\xb5\xd8\xd6\xb7\xc0\xb8\xca\xe4\xc8\xeb\xa1\xafabout:config\xa1\xaf\xb2\xa2\xbb\xd8\xb3\xb5\n\xc8\xbb\xba\xf3\xbd\xab\xa1\xafsigned.applets.codebase_principal_support\xa1\xaf\xc9\xe8\xd6\xc3\xce\xaa\xa1\xaftrue\xa1\xaf");
			}
			netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			var clip = Components.classes["@mozilla.org/widget/clipboard;1"].createInstance(Components.interfaces.nsIClipboard);
			if (!clip) {
				return;
			}
			var trans = Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);
			if (!trans) {
				return;
			}
			trans.addDataFlavor("text/unicode");
			var str = new Object();
			var len = new Object();
			var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
			var copytext = copy;
			str.data = copytext;
			trans.setTransferData("text/unicode", str, copytext.length * 2);
			var clipid = Components.interfaces.nsIClipboard;
			if (!clip) {
				return false;
			}
			clip.setData(trans, null, clipid.kGlobalClipboard);
		}
	}
	alert(msg);
	return false;
}
function selectAll(selectAllBoxId, boxId) {
	var selectAllBox = document.getElementById(selectAllBoxId);
	var boxes = document.getElementsByName(boxId);
	if (selectAllBox.checked) {
		for (i = 0; i < boxes.length; i++) {
			boxes[i].checked = true;
		}
	} else {
		for (i = 0; i < boxes.length; i++) {
			boxes[i].checked = false;
		}
	}
}
function imgAuto(img, maxW, maxH) {
	var oriImg = document.createElement("img");
	oriImg.src = img.src;
	if (oriImg.width == 0 || oriImg.height == 0)
		return;
	var oriW$H = oriImg.width / oriImg.height;

	if (oriImg.height > maxH) {
		img.height = maxH;
		img.width = maxH * oriW$H;
	}
	if (img.width > maxW) {
		img.width = maxW;
		img.height = maxW / oriW$H;
	}
	if (arguments.length == 3) {
		if (img.height > 0)
			img.style.marginTop = (maxH - img.height) / 2 + "px";
	}
	
}
function errorImage(obj, url) {
	if (url == null || url == "") {
		obj.src = "/images/noimage.jpg";
	} else {
		obj.src = url;
		obj.onerror = function () {
			obj.src = "/images/noimage.jpg";
		};
	}
}



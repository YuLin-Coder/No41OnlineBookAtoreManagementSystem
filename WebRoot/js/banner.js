// JavaScript Document
var $ = function (id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};

var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
	return destination;
};

var CurrentStyle = function(element){
	return element.currentStyle || document.defaultView.getComputedStyle(element, null);
};

var Bind = function(object, fun) {
	var args = Array.prototype.slice.call(arguments).slice(2);
	return function() {
		return fun.apply(object, args.concat(Array.prototype.slice.call(arguments)));
	};
};

var Tween = {
	Quart: {
		easeOut: function(t,b,c,d){
			return -c * ((t=t/d-1)*t*t*t - 1) + b;
		}
	},
	Back: {
		easeOut: function(t,b,c,d,s){
			if (s == undefined) s = 1.70158;
			return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
		}
	},
	Bounce: {
		easeOut: function(t,b,c,d){
			if ((t/=d) < (1/2.75)) {
				return c*(7.5625*t*t) + b;
			} else if (t < (2/2.75)) {
				return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
			} else if (t < (2.5/2.75)) {
				return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
			} else {
				return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
			}
		}
	}
};


//瀹瑰櫒瀵硅薄,婊戝姩瀵硅薄,鍒囨崲鏁伴噺
var SlideTrans = function(container, slider, count, options) {
	this._slider = $(slider);
	this._container = $(container);//瀹瑰櫒瀵硅薄
	this._timer = null;//瀹氭椂鍣�
	this._count = Math.abs(count);//鍒囨崲鏁伴噺
	this._target = 0;//鐩爣鍊�
	this._t = this._b = this._c = 0;//tween鍙傛暟
	
	this.Index = 0;//褰撳墠绱㈠紩
	
	this.SetOptions(options);
	
	this.Auto = !!this.options.Auto;
	this.Duration = Math.abs(this.options.Duration);
	this.Time = Math.abs(this.options.Time);
	this.Pause = Math.abs(this.options.Pause);
	this.Tween = this.options.Tween;
	this.onStart = this.options.onStart;
	this.onFinish = this.options.onFinish;
	
	var bVertical = !!this.options.Vertical;
	this._css = bVertical ? "top" : "left";//鏂瑰悜
	
	//鏍峰紡璁剧疆
	var p = CurrentStyle(this._container).position;
	p == "relative" || p == "absolute" || (this._container.style.position = "relative");
	this._container.style.overflow = "hidden";
	this._slider.style.position = "absolute";
	
	this.Change = this.options.Change ? this.options.Change :
		this._slider[bVertical ? "offsetHeight" : "offsetWidth"] / this._count;
};
SlideTrans.prototype = {
  //璁剧疆榛樿灞炴�
  SetOptions: function(options) {
	this.options = {//榛樿鍊�
		Vertical:	true,//鏄惁鍨傜洿鏂瑰悜锛堟柟鍚戜笉鑳芥敼锛�
		Auto:		true,//鏄惁鑷姩
		Change:		0,//鏀瑰彉閲�
		Duration:	50,//婊戝姩鎸佺画鏃堕棿
		Time:		10,//婊戝姩寤舵椂
		Pause:		4000,//鍋滈】鏃堕棿(Auto涓簍rue鏃舵湁鏁�
		onStart:	function(){},//寮�杞崲鏃舵墽琛�
		onFinish:	function(){},//瀹屾垚杞崲鏃舵墽琛�
		Tween:		Tween.Quart.easeOut//tween绠楀瓙
	};
	Extend(this.options, options || {});
  },
  //寮�鍒囨崲
  Run: function(index) {
	//淇index
	index == undefined && (index = this.Index);
	index < 0 && (index = this._count - 1) || index >= this._count && (index = 0);
	//璁剧疆鍙傛暟
	this._target = -Math.abs(this.Change) * (this.Index = index);
	this._t = 0;
	this._b = parseInt(CurrentStyle(this._slider)[this.options.Vertical ? "top" : "left"]);
	this._c = this._target - this._b;
	
	this.onStart();
	this.Move();
  },
  //绉诲姩
  Move: function() {
	clearTimeout(this._timer);
	//鏈埌杈剧洰鏍囩户缁Щ鍔ㄥ惁鍒欒繘琛屼笅涓�婊戝姩
	if (this._c && this._t < this.Duration) {
		this.MoveTo(Math.round(this.Tween(this._t++, this._b, this._c, this.Duration)));
		this._timer = setTimeout(Bind(this, this.Move), this.Time);
	}else{
		this.MoveTo(this._target);
		this.Auto && (this._timer = setTimeout(Bind(this, this.Next), this.Pause));
	}
  },
  //绉诲姩鍒�
  MoveTo: function(i) {
	this._slider.style[this._css] = i + "px";
  },
  //涓嬩竴涓�
  Next: function() {
	this.Run(++this.Index);
  },
  //涓婁竴涓�
  Previous: function() {
	this.Run(--this.Index);
  },
  //鍋滄
  Stop: function() {
	clearTimeout(this._timer); this.MoveTo(this._target);
  }
};

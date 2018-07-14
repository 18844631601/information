//对话框对象
function Dialog(json){
	//初始化数据
	if(json==null){
		json = {
			id : "smgDialog",
			width : 400,
			height : 250,
			title : "注意",
			content : "确定删除吗",
			btn1 : "确定",
			btn2 : "取消",
			color: "#999",
			initColor: "#f2f2f2"
		};
	};
	this.id = json.id;
	this.width = json.width;
	this.height = json.height;
	this.title = json.title;
	this.content = json.content;
	this.btn1 = json.btn1;
	this.btn2 = json.btn2;
	this.color = json.color;
	this.initColor = json.initColor;
};
//动态扩展内置方法
Dialog.prototype = {
	constructor:Dialog,//声明指向构造器  
	init:function(){
		var html = 
			"<div id='"+this.id+"-title'></div>"+
			"<a id='"+this.id+"-operate-no' href='javascript:;' class='operate-no'>×</a>"+
			"<div id='"+this.id+"-content'>"+
				"<span id='"+this.id+"-content-thing'></span>"+
			"</div>"+
			"<div id='"+this.id+"-operate'>"+
				"<a id='"+this.id+"-operate-cancle' class='operate-btn' href='javascript:;'>"+this.btn2+"</a>"+
				"<a id='"+this.id+"-operate-pass' class='operate-btn' href='javascript:;'>"+this.btn1+"</a>"+
			"</div>";
		var	smgDialogDom = document.getElementById(this.id);
		smgDialogDom.innerHTML = html;
		smgDialogDom.style.cssText = "width:"+this.width+"px;height:"+this.height+"px;background:"+this.initColor+";border-radius:5px;box-shadow:#888 0px 0px 6px";
		this.setDialogTitle();
		var smgDialogOperateNoDom = document.getElementById(this.id+"-operate-no");
		smgDialogOperateNoDom.style.cssText = "width:50px;height:40px;text-align:center;font:20px '宋体';color:#fff;line-height:40px;display:inline-block;position:absolute;left:"+(this.width-50)+"px;top:0;text-decoration:none;border-radius:0 5px 0 0;";
		this.setContent();
		var smgDialogOperateDom = document.getElementById(this.id+"-operate");
		smgDialogOperateDom.style.cssText = "width:"+this.width+"px;height:40px;background:"+this.color+";text-align:center;border-top:1px solid #ECECEC;border-radius:0 0 5px 5px;";
		var smgDialogOperatePassDom = document.getElementById(this.id+"-operate-pass");
		smgDialogOperatePassDom.style.cssText = "display:inline-block;width:60px;height:30px;background:#666;text-align:center;text-decoration:none;color:#fff;line-height:30px;margin-top:5px;border-radius:3px;";
		var smgDialogOperateCancleDom = document.getElementById(this.id+"-operate-cancle");
		smgDialogOperateCancleDom.style.cssText = "display:inline-block;width:60px;height:30px;background:#666;text-align:center;text-decoration:none;color:#fff;line-height:30px;margin-top:5px;margin-right:50px;border-radius:3px;";
	},
	setDialogTitle:function(){
		smgDialogTitleDom = document.getElementById(this.id+"-title");
		smgDialogTitleDom.innerHTML = this.title;
		smgDialogTitleDom.style.cssText = "width:"+(this.width-10)+";height:40px;background:"+this.color+";line-height:40px;font-size:16px;font-weight:500;font-family:'微软雅黑';padding-left:10px;border-radius:5px 5px 0 0;";
	},
	setContent:function(){
		var smgDialogContentDom = document.getElementById(this.id+"-content");
		smgDialogContentDom.style.cssText = "width:"+(this.width-40)+"px;height:"+(this.height-120)+"px;margin:20px auto;text-align:center;";
		var smgDialogContentThingDom = document.getElementById(this.id+"-content-thing");
		smgDialogContentThingDom.innerHTML = this.content;
		var length = this.content.length;
		var marginTop = 0;
		switch(true){
			case 0<=length && length<=44: marginTop=50;break;
			case 45<=length && length<=66: marginTop=40;break;
			case 67<=length && length<=88: marginTop=30;break;
			case 89<=length && length<=100: marginTop=20;break;
			case 101<=length && length<=122: marginTop=20;break;
			case 123<=length && length<=144: marginTop=10;break;
			case 145<=length && length<=166: marginTop=0;break;
			default:marginTop = 0;
		}
		smgDialogContentThingDom.style.cssText = "display:inline-block;margin-top:"+marginTop+"px;";
	}
};

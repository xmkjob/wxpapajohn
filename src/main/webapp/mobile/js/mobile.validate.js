var validateRegExp = {
	    decmal: "^([+-]?)\\d*\\.\\d+$",
	    // 浮点数
	    decmal1: "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$",
	    // 正浮点数
	    decmal2: "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$",
	    // 负浮点数
	    decmal3: "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$",
	    // 浮点数
	    decmal4: "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$",
	    // 非负浮点数（正浮点数 + 0）
	    decmal5: "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$",
	    // 非正浮点数（负浮点数 +
	    // 0）
	    intege: "^-?[1-9]\\d*$",
	    // 整数
	    intege1: "^[1-9]\\d*$",
	    // 正整数
	    intege2: "^-[1-9]\\d*$",
	    // 负整数
	    num: "^([+-]?)\\d*\\.?\\d+$",
	    // 数字
	    num1: "^[1-9]\\d*|0$",
	    // 正数（正整数 + 0）
	    num2: "^-[1-9]\\d*|0$",
	    // 负数（负整数 + 0）
	    ascii: "^[\\x00-\\xFF]+$",
	    // 仅ACSII字符
	    chinese: "^[\\u4e00-\\u9fa5]+$",
	    // 仅中文
	    color: "^[a-fA-F0-9]{6}$",
	    // 颜色
	    date: "^\\d{4}(\\-|\\/|\.)\\d{1,2}\\1\\d{1,2}$",
	    // 日期
	    email: "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$",
	    // 邮件
	    idcard: "^[1-9]([0-9]{14}|[0-9]{17})$",
	    // 身份证
	    ip4: "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$",
	    // ip地址
	    letter: "^[A-Za-z]+$",
	    // 字母
	    letter_l: "^[a-z]+$",
	    // 小写字母
	    letter_u: "^[A-Z]+$",
	    // 大写字母
	    mobile: "^0?(13|15|18|14|17)[0-9]{9}$",
	    // 手机
	    notempty: "^\\S+$",
	    // 非空 \\u0020-\\u002F\\u003A-\\u0040\\u005B-\\u0060\\u007B-\\u007E
	    password: "^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,32}$",
	    // 密码
	    fullNumber: "^[0-9]+$",
	    // 数字
	    picture: "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$",
	    // 图片
	    qq: "^[1-9]*[1-9][0-9]*$",
	    // QQ号码
	    rar: "(.*)\\.(rar|zip|7zip|tgz)$",
	    // 压缩文件
	    tel: "^[0-9\-()（）]{7,18}$",
	    // 电话号码的函数(包括验证国内区号,国际区号,分机号)
	    url: "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$",
	    // url
	    username: "^[A-Za-z][A-Za-z0-9_]{3,15}$",
	    // 户名,字母开头的数字，字母，下划线，4-16位
	    deptname: "^[A-Za-z0-9_()（）\\-\\u4e00-\\u9fa5]+$",
	    // 单位名
	    zipcode: "^\\d{6}$",
	    // 邮编
	    realname: "^[A-Za-z\\u4e00-\\u9fa5]+$",
	    // 真实姓名
	    companyname: "^[A-Za-z0-9_()（）\\-\\u4e00-\\u9fa5]+$",
	    companyaddr: "^[A-Za-z0-9_()（）\\#\\-\\u4e00-\\u9fa5]+$",
	    companysite: "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&#=]*)?$"
	};

// 验证规则
var validateRules = {
    isNull: function(str) {
        return (str == "" || typeof str != "string");
    },
    betweenLength: function(str, _min, _max) {
        return (str.length >= _min && str.length <= _max);
    },
    isUid: function(str) {
        return new RegExp(validateRegExp.username).test(str);
    },
    fullNumberName: function(str) {
        return new RegExp(validateRegExp.fullNumber).test(str);
    },
    isPwd: function(str) {
        return new RegExp(validateRegExp.password).test(str);
    },
    isPwdRepeat: function(str1, str2) {
        return (str1 == str2);
    },
    isEmail: function(str) {
        return new RegExp(validateRegExp.email).test(str);
    },
    isTel: function(str) {
        return new RegExp(validateRegExp.tel).test(str);
    },
    isMobile: function(str) {
        return new RegExp(validateRegExp.mobile).test(str);
    },
    checkType: function(element) {
        return (element.attr("type") == "checkbox" || element.attr("type") == "radio" || element.attr("rel") == "select");
    },
    isRealName: function(str) {
        return new RegExp(validateRegExp.realname).test(str);
    },
    isIdCard: function(str) {
        return new RegExp(validateRegExp.idcard).test(str);
    },
    isCompanyname: function(str) {
        return new RegExp(validateRegExp.companyname).test(str);
    },
    isCompanyaddr: function(str) {
        return new RegExp(validateRegExp.companyaddr).test(str);
    },
    isCompanysite: function(str) {
        return new RegExp(validateRegExp.companysite).test(str);
    },
    simplePwd: function(str) {
        return pwdLevel(str) == 1;
    },
    weakPwd: function(str) {
        for (var i = 0; i < weakPwdArray.length; i++) {
            if (weakPwdArray[i] == str) {
                return true;
            }
        }
        return false;
    }
};

//验证文本
var validatePrompt = {
    product: {
        onFocus: "",
        succeed: "",
        isNull: "请选择要预约的产品",
        error: ""
    },
    name: {
        onFocus: "",
        succeed: "",
        isNull: "请填写姓名",
        error: {
            badFormat: "姓名请填写汉字或英文"
        }
    },
    phone: {
        onFocus: "",
        succeed: "",
        isNull: "请填写电话号码",
        error: {
            badFormat: "电话号码请填写数字"
        }
    },
    amount: {
        onFocus: "",
        succeed: "",
        isNull: "请填写预约投资金额",
        error: {
            badFormat: "金额请填写数字"
        }
    },
    empty: {
        onFocus: "",
        succeed: "",
        isNull: "",
        error: ""
    }
};


function showError(hintid, errorstr){
    $(hintid).html(errorstr);
    $(hintid).show();
}

function mynameBlur(){

    var myname = $("#name").val();

    if (myname==null || myname == "") {
    	showError("#namehint",validatePrompt.name.isNull);	
        return;
    }

    if (!validateRules.isRealName(myname)) {
    	showError("#namehint",validatePrompt.name.error.badFormat);
        return;
    }
    
    showError("#namehint","");	
}

function myphoneBlur(){

    var myphone = $("#phone").val();

    if (myphone==null || myphone == "") {
    	showError("#phonehint",validatePrompt.phone.isNull);	
        return;
    }

    if (!validateRules.isMobile(myphone) && !validateRules.isTel(myphone)) {
    	showError("#phonehint",validatePrompt.phone.error.badFormat);
        return;
    }
    showError("#phonehint","");	
}

function myamountBlur(){

    var myamount = $("#amount").val();

    if (myamount==null || myamount == "") {
    	showError("#amounthint",validatePrompt.amount.isNull);	
        return;
    }

    if (!validateRules.fullNumberName(myamount)) {
    	showError("#amounthint",validatePrompt.amount.error.badFormat);
        return;
    }
    showError("#amounthint","");
}
//登录
function ordernow() {
	//检测参数
    var myname = $("#name").val();

    if (myname==null || myname == "") {
    	showError("#namehint",validatePrompt.name.isNull);	
        return;
    }

    if (!validateRules.isRealName(myname)) {
    	showError("#namehint",validatePrompt.name.error.badFormat);
        return;
    }
    showError("#namehint","");
    
    var myphone = $("#phone").val();

    if (myphone==null || myphone == "") {
    	showError("#phonehint",validatePrompt.phone.isNull);	
        return;
    }

    if (!validateRules.isMobile(myphone) && !validateRules.isTel(myphone)) {
    	showError("#phonehint",validatePrompt.phone.error.badFormat);
        return;
    }
    showError("#phonehint","");

    var myamount = $("#amount").val();

    if (myamount==null || myamount == "") {
    	showError("#amounthint",validatePrompt.amount.isNull);	
        return;
    }

    if (!validateRules.fullNumberName(myamount)) {
    	showError("#amounthint",validatePrompt.amount.error.badFormat);
        return;
    }
    showError("#amounthint","");
    
    var myselect = $("#pid").val();
    
    if (myselect==null || myselect == "") {
    	showError("#producthint",validatePrompt.product.isNull);	
        return;
    }
    
    showError("#producthint","");
   
    
	//如果参数没有问题
	$.ajax({
		type : "POST",
		url : "ordernow?r=" + Math.random(),
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : $("#orderform").serialize(),
		success : function(result) {
			if (result) {
				var retCode = result.code;
				var retMsg = result.msg;
				if(retCode == 1){
					//success
					location.href = result.data;
				}else{
					alert(retMsg);
				}
			}
		}
	});	
}

function binding() {
	
    var username = $("#username").val();
    var password = $("#password").val();

    if (username==null || username == "") {
		$("#prompt").html("请填写账号");
		$("#prompt").show();
		setTimeout(function(){
			$("#prompt").hide();               
		},500);
        return;
    }
    
    if (password==null || password == "") {
		$("#prompt").html("请输入密码");
		$("#prompt").show();
		setTimeout(function(){
			$("#prompt").hide();               
		},500);
        return;
    }
	
	$.ajax({
		type : "POST",
		url : "tobinding?r=" + Math.random(),
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : $("#bindingform").serialize(),
		success : function(result) {
			if (result) {
				var retCode = result.code;
				var retMsg = result.msg;
				if(retCode == 1){
					//success
					location.href = result.data;
				}else{
					$("#prompt").html(retMsg);
					$("#prompt").show();
					setTimeout(function(){
						$("#prompt").hide();               
					},500);
				}
			}
		}
	});	
}

function unbinding() {
	
	 var wid = $("#wid").val();
	 
	$.ajax({
		type : "GET",
		url : "tounbinding?wid=" + wid,
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(result) {
			if (result) {
				var retCode = result.code;
				var retMsg = result.msg;
				if(retCode == 1){
					//success
					location.href = result.data;
				}else{
					$("#prompt").html(retMsg);
					$("#prompt").show();
					setTimeout(function(){
						$("#prompt").hide();               
					},500);
				}
			}
		}
	});	
}


/**
 * register.jsp页面的注册信息，验证使用
 */

//// 输入框获得焦点时，显示提示内容(未定义该方法)
//function showDesc(obj) {
//	var id = obj.name;
//	document.getElementById(id).style.display = "inline";
//}
// 输入框失去焦点时检验输入内容是否有效
//function checkText(obj) {
//	// 获取输入框的id值
//	var id = obj.name;
//	var text = document.getElementById(id.toString().toUpperCase()).value;
//
//	// 判断是否为空
//	if (text.replace(/\s/g, "") == "") {
//		document.getElementById(id).innerHTML = "输入不能为空";
//	} else {// 组装方法
//		// 取首字母转换为大写,其余不变
//		var firstChar = id.charAt(0).toString().toUpperCase();
//		//
//		var strsub = id.substring(1, id.length);
//		var strMethod = "check" + firstChar + strsub + "()";
//		var isTrue = eval(strMethod);
//		if (isTrue) {
//			document.getElementById(id).innerHTML = "输入有效";
//		}
//	}
//
//}

//判断用户名是否为空，空串，以及长度是否符合要求
function checkUsername() {
	var name =$('#username').val();
	if (name.replace(/\s/g, "") == "") {
		$('#span1').html("用户名不能为空，请重新输入");
	}else if(name.length<4){
		$('#span1').html("用户名太短，请重新输入");
	}else{
		$('#span1').html("√");
	}
}

//判断输入的密码是否符合要求
function checkPwd1() {
	var password =$('#password').val();
	if (password.replace(/\s/g, "") == "") {
		$('#error_pwd').html("密码不能为空，请重新输入");
	}else if(password.length<8){
		$('#error_pwd').html("密码太短，请重新输入");
	}else{
		$('#error_pwd').html("√");
	}
}

//验证2次输入的密码是否一致
function checkPwd2() {
	var password = $('#password').val();
	var password2 = $('#repassword').val();
	if (password != password2) {
		$('#error2_pwd').html("两次输入密码不一致");
	}else {
		$('#error2_pwd').html("√");
	}
}

//检查输入的号码是否合法
function checkTell() {
	// 利用正则表达式对输入数据匹配
	var tell = $('#telephone').val();
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (expr.test(tell)) {
		$('#error_tell').html("不能输入非数字字符");
	}else{
		$('#error_tell').html("√");
	}
}

//检查输入的email是否合法
function checkEmail() {
	// 利用正则表达式对输入数据匹配
	var email = $('#email').val();
	// 以字母或数字开头，跟上@,字母数字以.com结尾
	var expr = /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
	if (!expr.test(email)) {
		$('#error_email').html("输入的邮箱格式有误");
	}else{
		$('#error_email').html("√");
	}
}

//验证输入的日期是否大于当前日期
function checkBirth() {
	var date = new Date();
	var date_str = date.getFullYear()+"" + (date.getMonth()+1) +""+date.getDate();
	var date_choose = $('#birth').val();
	//最好将其转换成整形，方便比较大小
	var date_now = parseInt(date_str);
	var date_birth = parseInt(date_choose.replace(/-/g,''));
	
	if (date_birth > date_now) {
		$('#error_birth').html("您输入的日期不合法，请重新选择！");
	}else {
		$('#error_birth').html("√");
	}
}

function changeImgCode() {
	$('#checkImg').attr('src','/IStore/user/checkImg?abc='+Math.random());
}

/*function verdictImg(){
	var getImg = pageContext.session.getAttribute("randomString");
	var inputImg = $('checkcode').val();
	if (getImg == inputImg) {
		$('error_checkcode').html("√");
	}else {
		$('error_checkcode').html("验证码输入错误");
	}
	
}*/
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
<script type="text/javascript">
	/* 使用ajax做异步提交验证，验证不成功，返回当前页面，提示错误信息，验证成功，转到管理页面 */
	$.ajax();
</script>
</head>
<body>
	<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="#" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="logname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
		<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
	</body>
</body>
</html>
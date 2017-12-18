<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="short cut icon" href="<%=request.getContextPath() %>/favicon.ico" />
<title>商城首页</title>
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container register">
		
			您的用户名或密码输入错误，请重新输入!!!<a href="<%=request.getContextPath() %>/user/loginUI">跳转至登录页面</a>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
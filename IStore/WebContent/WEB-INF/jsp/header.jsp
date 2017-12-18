<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="<%=request.getContextPath()%>/index"> <img
				src="${pageContext.request.contextPath}/image/logo.png" alt="网上商城">
			</a>
		</div>
	</div>
	<div class="span9">
		<div class="headerAd">
			<img src="${pageContext.request.contextPath}/image/header.jpg"
				width="320" height="50" alt="正品保障" title="正品保障">
		</div>
	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
			<c:choose>
				<c:when test='<%=session.getAttribute("userexist")==null%>'>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/loginUI">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/registUI">注册</a>|
					</li>
				</c:when>
				<c:otherwise>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><%=session.getAttribute("userexist")%>|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;">
						<!-- 打开我的订单页面，URL有问题，还未修改 --> <a
						href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
						|
					</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/quit">退出</a>|</li>
				</c:otherwise>
			</c:choose>
				<li><a>会员中心</a> |</li>
				<li><a>购物指南</a> |</li>
				<li><a>关于我们</a></li>
			</ul>
		</div>
		<div class="cart">
			<!-- 打开我的订单页面，URL有问题，还未修改 -->
			<a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
		</div>
		<div class="phone">
			客服热线: <strong>800/000000001</strong>
		</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
			<li><a href="${ pageContext.request.contextPath }/index">首页</a>
				|</li>
			<!-- 获取查询到的商品信息返回 -->
			<%-- <%-- <s:iterator var="c" value="#session.cList">
			<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a> |</li>
		</s:iterator> --%>


		</ul>
	</div>
</div>
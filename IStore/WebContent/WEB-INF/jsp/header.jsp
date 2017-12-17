<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="<%=request.getContextPath() %>/index"> <img
				src="${pageContext.request.contextPath}/image/logo.png"
				alt="网上商城">
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
				<!-- 判断session中是否有用户，若无，显示登录和注册(暂时未实现不说了20171217) -->
				<!-- <c:if test="session.getAttribute('user') == null"> -->
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/loginUI">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user/registUI">注册</a>|
					</li>
				<!-- </c:if test = "session.getAttribute('user') != null" > -->
				<%-- <c:if>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;">session.getAttribute('user')|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;">
						<!-- 打开我的订单页面，URL有问题，还未修改 --> <a
						href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
						|
					</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;">
						<!-- 打开我的订单页面，URL有问题，还未修改 --> <a
						href="${ pageContext.request.contextPath }/user_quit.action">退出</a>|
					</li>
				</c:if> --%>

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
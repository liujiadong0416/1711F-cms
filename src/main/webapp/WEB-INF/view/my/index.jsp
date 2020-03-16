<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>

<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<title>今日头条-个人中心</title>
</head>
<body>
	<div class="container-fluid">
		<!-- 头 -->
		<div class="row">
			<div class="col-md-12" style="background-color: #563D7C;height: 60px;">
				<a href="/"><img alt="..." src="/resource/img/-296b6717622a6d6.jpg" style="height: 60px;widows: 60px;"></a>
				<span style="color: white;">今日头条-首页</span>
				<div style="float: right;">
					<c:if test="${null!=sessionScope.user }">
						 <div class="btn-group dropleft">
							  <button style="height: 25px;margin-top: -5px;" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    <span style="color: white; size: 2px;">登录信息</span>
							  </button>
							  <div class="dropdown-menu">
							    <a class="dropdown-item" href="#">${sessionScope.user.username }</a>
							    <a class="dropdown-item" href="/passport/logout">注销</a>
							  </div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<!-- boby -->
		<div class="row" style="padding-top: 5px;">
			<div class="col-md-2">
				<ul class="list-group">
					<li class="list-group-item active"><a href="#" data="/my/articles"><font style="color: black;">我的文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font style="color: black;">发布文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/collect"><font style="color: black;">我的收藏</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font style="color: black;">我的评论</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font style="color: black;">个人信息</font></a></li>
				</ul>
			</div>
			<div class="col-md-10" id="center">
				<!-- 先加载样式 -->
				<div style="display: none;">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			 $("#center").load("/my/articles");
			$("li").click(function() {
				var url=$(this).children().attr("data");
				$("li").removeClass("active");
				$(this).addClass("list-group-item active")
				$("#center").load(url);
			})
		})
	</script>
</body>
</html>
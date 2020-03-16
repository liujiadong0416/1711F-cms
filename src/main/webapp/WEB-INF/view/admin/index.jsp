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
<title>今日头条-管理</title>
</head>
<body>
	<div class="container-fluid">
		<!-- tou -->
		<div class="row" style="background-color: #563D7C;height: 60px;">
			<div class="col-md-12">
				<a href="/"><img class="rounded" alt="" src="/resource/img/-296b6717622a6d6.jpg" style="height: 60px;widows: 60px;"></a>
				<span style="color: white;">今日头条-管理员中心</span>
				<div class="btn-group dropleft" style="float: right;">
					<button style="height: 25px;margin-top: -5px;" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    <span style="color: white; size: 2px;">登录信息</span>
					 </button>
					<div class="dropdown-menu">
					    <a class="dropdown-item" href="#">${sessionScope.admin.username }</a>
					    <a class="dropdown-item" href="/passport/logout">注销</a>
					 </div>
				</div>
			</div>
		</div>
		
		<!-- tou -->
		<div class="row" style="padding-top: 5px;">
			<!-- 左侧菜单 -->
			<div class="col-md-2 rounded" style="text-align: center;">
				<nav class="nav flex-column">
				  <a class="list-group-item active" href="#" data="/admin/articles">文章审核</a>
				  <a class="list-group-item" href="#" data="/admin/users">用户管理</a>
				  <a class="list-group-item" href="#">栏目管理</a>
				  <a class="list-group-item" href="#">分类管理</a>
				  <a class="list-group-item" href="#">系统设置</a>
				</nav>
			</div>
			<!-- 右侧 -->
			<div class="col-md-10" id="center"></div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//默认显示文章审核
			$("#center").load("/admin/articles");
			$("a").click(function() {
				var url=$(this).attr("data");
				$("a").removeClass("active");
				$(this).addClass("list-group-item active")
				$("#center").load(url);
			})
		})
	</script>
</body>
</html>
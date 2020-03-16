<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>今日头条</title>
</head>
<body>
	<div class="container-fluid">
		<!-- tou -->
		<div class="row" style="background-color: #563D7C;height: 25px;">
			<div class="col-md-12">
				<span style="color: white; size: 2px;margin-left: 3px;">下载APP</span>
				<div style="float: right;">
					<!-- 从session获取当前登录对象 -->
					<c:if test="${null==sessionScope.user }">
						<button onclick="zc()" style="margin-top: -6px;" type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">
 							<span style="color: white; size: 2px;margin-left: 3px;">注册</span>
						</button>
						<button onclick="dl()" style="margin-top: -6px;" type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">
 							<span style="color: white; size: 2px;margin-left: 3px;">登录</span>
						</button>
					</c:if>
					<c:if test="${null!=sessionScope.user }">
						 <div class="btn-group dropleft">
							  <button style="height: 25px;margin-top: -5px;" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    <span style="color: white; size: 2px;">登录信息</span>
							  </button>
							  <div class="dropdown-menu">
							    <a class="dropdown-item" href="#">${sessionScope.user.username }</a>
							    <a class="dropdown-item" href="/my">个人中心</a>
							    <a class="dropdown-item" href="/passport/logout">注销</a>
							  </div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		
		<!--  -->
		<div class="row">
			<!-- 左侧菜单 -->
			<div class="col-md-2" style="padding-top: 10px;">
				<ul>
					<!-- 今日头条的log -->
					<li style="margin-bottom: 10px;"><a href="/"> <img alt="" src="/resource/img/logo-index.png"
							style="width: 108px; height: 27px">
					</a></li>
					<!-- 热点 -->
					<li><a  href="/?hot=1" class="channel-item ${article.channelId==null?'active':'' }">热点</a></li>
					<!-- 遍历所有栏目 -->
					<c:forEach items="${channels}" var="channel">
						<li><a href="/?channelId=${channel.id }" class="channel-item ${article.channelId==channel.id?'active':'' }">${channel.name }</a></li>
					</c:forEach>
				</ul>
			</div>
			<!-- 中间 -->
			<div class="col-md-7">
				<!-- 显示子分类 -->
				<!-- 栏目ID不为null -->
				<c:if test="${article.channelId==null}">
					<div class="subchannel" style="margin: 5px;5px;5px; 5px;">
						<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
						  <ol class="carousel-indicators">
						   <c:forEach items="${list }" var="l" varStatus="i">
						   		 <li data-target="#carouselExampleCaptions" data-slide-to="${i.index }" class="active"></li>
						   </c:forEach>
						  </ol>
						  <div class="carousel-inner">
						  <c:forEach items="${list }" var="g" varStatus="i">
							  <div class="carousel-item ${i.index==0?'active':'' }">
							      <img src="/pic/${g.url }" class="d-block w-100 rounded" alt="..." style="width: 300px;height: 400px;">
							      <div class="carousel-caption d-none d-md-block">
							        <h5>${g.title }</h5>
							      </div>
							    </div>
						  </c:forEach> 
						  </div>
						  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
					</div>
				</c:if>
				
				<!-- 显示子分类 -->
				<!-- 栏目ID不为null -->
				<c:if test="${article.channelId!=null}">
					<div class="subchannel">
						<ul>
							<li class="sub-item ${article.categoryId==null?'sub-selected':'' }"><a href="/?channelId=${article.channelId }">全部</a></li>
							<c:forEach items="${selectsCategory }" var="g">
								<li class="sub-item ${article.categoryId==g.id?'sub-selected':'' }"><a href="/?channelId=${article.channelId }&categoryId=${g.id }">${g.name }</a></li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<!-- 分类下的文章 -->
				<div>
					 <c:forEach items="${info.list}" var="article">
					<div class="media">
						<img src="/pic/${article.picture}" class="mr-3 rounded" alt="..." style="width: 100px;height: 100px;">
						<div class="media-body">
							<h5 class="mt-0"><a target="blank" href="/articleDetail?id=${article.id }">${article.title }</a></h5>
							<p>${article.user.username } <fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						</div>
					</div><hr>
                  </c:forEach>
                  <jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
				</div>
			</div>
			<!-- 右侧 -->
			<div class="col-md-3">
				<div class="card" style="width: 18rem; margin-top: 5px;">
					<div class="card-header text-white bg-warning mb-3">最新文章</div>
					  <div class="card-body">
					  		<!-- 最新文章 -->
					  		<c:forEach items="${selects2.list }" var="g">
								<div class="media" style="margin-top: 5px;">
								  <img src="/pic/${g.picture }" class="mr-3 rounded" alt="..." style="width: 60px;height: 60px;">
								  <div class="media-body">
								    <h6 class="mt-0"><a href="/articleDetail?id=${g.id }" target="blank">${g.title }</a></h6>
								  </div>
								</div>
								<hr>
							</c:forEach>
					  </div>
					</div>
			</div>
		</div>
		<!-- 注册 / 登录-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel"><span id="title"></span></h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body" id="sss">
			       	 
			      </div>
			    </div>
			  </div>
		</div>
	</div>
	<script type="text/javascript">
		function goPage(page) {
			var channelId='${article.channelId}';
			var categoryId='${article.categoryId}';
			var url="/?channelId="+channelId+"&pageNum="+page;
			if(categoryId!=""){
				url=url+"&categoryId="+categoryId;
			}
			location.href=url;
		}
		function zc() {
			$("#title").append("用户注册")
			$("#sss").load("/passport/reg");
		}
		function dl() {
			$("#title").html("")
			$("#title").append("用户登录")
			$("#sss").load("/passport/login");
		}
	</script>
</body>
</html>
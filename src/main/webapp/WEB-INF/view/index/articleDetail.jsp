<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>${article.title }</title>
</head>
<body>
	<div class="container-fluid">
		<!-- tou -->
		<div class="row" style="background-color: #563D7C;height: 25px;">
			<div class="col-md-12">
				<span style="color: white; size: 2px;margin-left: 3px;">下载APP</span>
			</div>
		</div>
		
		<!--  -->
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-2"></div>
			<div class="col-md-7">
				<h2>${article.title }</h2>
				<p>${article.user.username } <fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<c:if test="${collect!=null}">
				 <button type="button" onclick="deleteCollect()" class="btn btn-link">★&nbsp;  取消收藏</button>
				</c:if>
				<c:if test="${collect==null}">
				     <button type="button" onclick="collect(1)" class="btn btn-link">☆ &nbsp;  未收藏</button>
				</c:if>
				<hr>
				${article.content }
				<hr>
				<c:if test="${sessionScope.user!=null }">
					<div>
						<h5>评论:</h5>
						<textarea name="content" rows="8" cols="20"  style="width:950px;"></textarea>
						<button type="button" onclick="addComment()" class="btn btn-info">提交</button>
					</div>
				</c:if>
				 <div>
				 	<c:forEach items="${info.list }" var="g">
				 		${g.user.username } 
				 		<fmt:formatDate value="${g.created }"/>
				 		<br>
				 		${g.content }<br>
				 	</c:forEach>
				 </div>
			</div>
			<div class="col-md-3">
				<div class="card" style="width: 18rem; margin-top: 6px">
					<div class="card-header">评论排行榜</div>
					<div class="card-body">
						<!-- 最新文章 --10篇 -->
						<c:forEach items="${info2.list}" var="article" varStatus="i">
						 <p>  ${i.count} ${article.title }</p>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//收藏
		function collect() {
			var text='${article.title}';
			var url=location.href;
			$.post("/addCollect",{text:text,url:url},function(flag){
				if(flag){
					alert("收藏成功");
					window.location.reload();
				}else{
					alert("收藏失败，需要登录后才能收藏")
				}
			})
		}
		//取消收藏
		function deleteCollect() {
			var id='${collect.id}';
			$.post("/deleteCollect",{id:id},function(flag){
				if(flag){
					alert("取消收藏成功");
					window.location.reload();
				}else{
					alert("取消收藏失败，需要登录后才能收藏")
				}
			})
		}
		function addComment() {
			var articleId='${article.id}';
			var content=$("[name='content']").val();
			$.post("/addComment",{articleId:articleId,content:content},function(flag){
				if(flag){
					alert("评论成功");
					window.location.reload();
				}else{
					alert("评论失败，需要登录后才能评论")
				}
			})
		}
	</script>
</body>
</html>
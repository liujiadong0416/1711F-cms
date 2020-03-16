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
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>我的文章</title>
</head>
<body>
<c:forEach items="${info.list}" var="collect">
<div class="media">
  <div class="media-body">
    <h5 class="mt-0">${collect.text }</h5>
    <fmt:formatDate value="${collect.created }" pattern="yyyy-MM-dd HH:mm:ss"/>
   	<div style="float: right;">
   		<button onclick="dele(${collect.id })" type="button" class="btn btn-info" style="margin-top: -10px;">取消收藏</button>
   	</div>
  </div> 
</div>
 <hr/>
</c:forEach>
<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
<script type="text/javascript">
	function goPage(page) {
		$("#center").load("/my/collect?pageNum="+page);
	}
	function dele(id) {
		$.post("/deleteCollect",{id:id},function(flag){
			if(flag){
				alert("取消收藏成功");
				window.location.reload();
			}else{
				alert("取消收藏失败，需要登录后才能收藏")
			}
		})
	}
</script>
</body>
</html>
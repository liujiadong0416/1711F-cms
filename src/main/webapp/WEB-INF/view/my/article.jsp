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
<title>我的文章</title>
</head>
<body>
<c:forEach items="${info.list}" var="article">
<div class="media">
  <img src="/pic/${article.picture }" class="mr-3 rounded" alt="..." style="width: 100px;height: 100px;padding-top: 5px;">
  <div class="media-body">
    <h5 class="mt-0">${article.title }</h5>
    <div style="float: right;">
    	<!-- Button trigger modal -->
		<button type="button" class="btn btn-link" data-toggle="modal" onclick="articleDetail(${article.id })"
		 data-target="#exampleModalLong">详情</button>
    </div>
  </div>
</div>
 <hr/>
</c:forEach>
<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle" id="title"><span id="title"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="content">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
<script type="text/javascript">
	function articleDetail(id) {
		$.get("/my/articleDetail",{"id":id},function(list){
			$("#content").empty();
			$("#title").append(list.title);
			$("#content").append(list.content);
		})
	}
	function goPage(page) {
		$("#center").load("/my/articles?pageNum="+page);
	}
</script>
</body>
</html>
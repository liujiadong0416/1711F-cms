<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="/resource/jquery/screen.css" />
<script type="text/javascript" src="/resource/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>今日头条-注册</title>
</head>
<body>
	<div class="container">
		<form id="form1">
			<div class="form-group">
    			<label for="username">用户名:</label>
    			<input type="text" class="form-control" id="username" name="username">
 			 </div>
 			 <div class="form-group">
    			<label for="password">密码:</label>
    			<input type="password" class="form-control" id="password" name="password">
 			 </div>
 			 <div class="form-group">
    			<label for="prpass">确认密码:</label>
    			<input type="password" class="form-control" id="prpass" name="repassword">
 			 </div>
 			  <div class="form-group form-inline">
    			<label for="gender">性别:</label>
    			<input type="radio" class="form-control" class="form-check-input" id="gender" name="gender" value="1">男
    			<input type="radio" class="form-control" class="form-check-input" id="gender" name="gender" value="0">女
 			 </div>
 			 <div class="form-group">
				<button type="submit" class="btn btn-info">注册</button>
				<button type="reset" class="btn btn-warning">重置</button>
 			 </div>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#form1").validate({
				rules:{
					username:{
						required:true,
						rangelength:[2,10],
					},
					password:{
						 required:true,//密码不能为空
						 rangelength:[6,10],//密码长度在6-10之间
					 }, 
					 repassword:{//确认密码和密码一致
						 equalTo:"#password"
					 }
				},
				messages:{
					username:{
						required:"用户名不能为空",
						rangelength:"长度为2-10"
					},
					 password:{
						 required:"密码不能为空",
						 rangelength:"密码长度在6-10之间"
					 }, 
					 repassword:{
						 equalTo:"两次密码不一致",
					 },
				},submitHandler:function(flag){
					 //如果校验通过。则执行注册
					 $.post("/passport/reg",$("#form1").serialize(),function(result){
						 if(result.code==200){
							 $("#title").html("登录");
							 $("#sss").load("/passport/login");
						 }else{
							 alert(result.msg);
						 }
					 })
				 }
			})
		})
	</script>
</body>
</html>
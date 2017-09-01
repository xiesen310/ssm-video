<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登录</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.png" type="image/x-icon">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
		<style>
			.container{
				width: 300px;
				height: 200px;
				/*border: 1px solid red;*/
				margin-top: 16%;
			}
			body{
				background-color: #e4e4e4;
			}
		</style>
		
		<script type="text/javascript">
		$(function(){
			$("#checkForm").validate({
				rules:{
					username:{
						required:true,
						minlength:3
					},
					password:{
						required:true
					}
				},
				messages:{
					username:{
						required:"用户名不能为空",
						minlength:"长度太小"
					},
					password:{
						required:"请输入密码"
					}
				}
			});
		});
	</script>
		
	</head>

	<body>
		<div class="container">
			<img src="${pageContext.request.contextPath }/img/logo.png" alt="智游教育" class="img-rounded" width="260px" height="60px">
			<form action="${pageContext.request.contextPath }/admin/dologin.action" method="post" id="checkForm">
				<div class="form-group">
					<input type="text" class="form-control" name="username"  placeholder="用户名">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"  placeholder="登录密码">
				</div>
				<button type="submit" class="btn btn-success btn-block">登录</button>
			</form>
		</div>
	</body>

</html>
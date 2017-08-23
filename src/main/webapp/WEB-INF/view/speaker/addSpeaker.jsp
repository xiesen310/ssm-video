<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加主讲人信息</title>
		<link rel="icon" href="img/favicon.png" type="image/x-icon">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style>
			body{
				background-color: #e4e4e4;
			}
		</style>
	</head>

	<body>
	<!-- 导航栏开始 -->
	<%@ include file="../head.jsp" %>
	<!-- 导航栏结束 -->
	
		<div class="container">
			<!--巨幕开始-->
			<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
				<h2>编辑主讲人-主讲人管理</h2>
			</div>
			<!--巨幕结束-->

			<!--表单开始-->

			<form class="form-horizontal" action="${pageContext.request.contextPath }/speaker/addSpeaker.action" method="post">

				<div class="form-group">
					<label class="col-sm-2 control-label">名字</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="speaker_name" placeholder="主讲人姓名">
					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-2 control-label">职业</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="speaker_job" placeholder="请填写主讲人职业">
					</div>
				</div>

				<div class="form-group">
					<label  class="col-sm-2 control-label">头像图片</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="speaker_head_url" placeholder="图片地址">
					</div>
				</div>

				
				<div class="form-group">
					<label  class="col-sm-2 control-label">简介</label>
					<div class="col-sm-10">
						<textarea class="form-control" name="speaker_descr" rows="3"></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">保存</button>
						<a href="javascript:history.go(-1);" class="btn btn-default">返回列表</a>
					</div>
				</div>

			</form>
			<!--表单结束-->

		</div>
		
		<!-- 页脚开始 -->
		<%@ include file="../footer.jsp" %>
		<!-- 页脚结束 -->
	</body>

</html>
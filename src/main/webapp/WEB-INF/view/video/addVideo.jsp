<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加视频</title>
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
	<jsp:include page="/WEB-INF/view/head.jsp">
		<jsp:param value="video" name="formjsp"/>
	</jsp:include>
	<!-- 导航栏结束 -->
			
		<div class="container">
			<!--巨幕开始-->
			<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
				<h2>编辑视频信息-视频管理</h2>
			</div>
			<!--巨幕结束-->

			<!--表单开始-->

			<form class="form-horizontal" action="${pageContext.request.contextPath }/video/addVideo.action" method="post">
				
				<div class="form-group">
					<label  class="col-sm-2 control-label">视频标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="video_title" placeholder="视频标题">
					</div>
				</div>
				
				<div class="form-group">
					<label  class="col-sm-2 control-label">主讲人</label>
					<div class="col-sm-10">
						<select class="form-control" name="speaker_id">
							<c:forEach items="${speakerList }" var="speaker">
								<option value="${speaker.id }">${speaker.speaker_name }</option>
							</c:forEach>
						</select>
					</div>
					
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">所属课程</label>
					<div class="col-sm-10">
						<select class="form-control" name="course_id">
							<c:forEach items="${subjectList }" var="subject">
								<option value="${subject.id }">${subject.subject_name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">视频时长</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="video_length" placeholder="视频时长">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="video_image_url" placeholder="图片地址">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"  name="video_url" placeholder="视频播放地址">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">视频简介</label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="3" name="video_descr"></textarea>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">保存</button>
						<a href="javascript:history.go(-1);" class="btn btn-default" >返回列表</a>
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
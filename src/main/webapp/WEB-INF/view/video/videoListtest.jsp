<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://zhiyou100.com/common/" prefix="xs" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>视频管理</title>
		<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.png" type="image/x-icon">
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/jquery-confirm.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>
		<style>
			body {
				background-color: #e4e4e4;
			}
			
			$(function(){
				$("#btn").click(function(){
					alert("1111");
				});
			});
		</style>
	</head>

	<body>
	<!-- 导航栏开始 -->
	<%@ include file="../head.jsp" %>
	<!-- 导航栏结束 -->
		<div class="container">
			<!--巨幕开始-->
			<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
				<h2>视频列表-视频管理</h2>
			</div>
			<!--巨幕结束-->
<button id="btn">按钮</button>
			<!--搜索表单开始-->
			<form class="form-inline" action="${pageContext.request.contextPath }/video/videoList.action">
				<!--添加视频开始-->
				<a href="${pageContext.request.contextPath }/video/addVideo.action" class="btn btn-primary">添加视频</a>
				<!--添加视频结束-->

				<!--批量删除开始-->
				<a  class="btn btn-primary" onclick="mulDelete()">批量删除 <span class="badge" id="deleteNum">0</span></a>
				<!--批量删除结束-->
				<div class="pull-right">
					<div class="form-group">
						<input type="text" name="video_title" class="form-control" placeholder="视频标题">
					</div>

					<div class="form-group">
						<select class="form-control" name="speaker_name">
							<option value="">请选择主讲人</option>
							<c:forEach items="${speakerList }" var="speaker">
								<option value="${speaker.speaker_name }" ${speaker.id eq video.speaker_id ? "selected":"" } >${speaker.speaker_name }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<select class="form-control" name="course_name">
							<option value="">请选择课程</option>
							<c:forEach items="${courseList }" var="course">
								<option value="${course.course_name }" ${course.id eq video.course_id ? "selected":"" } >${course.course_name }</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</form>
			<!--搜索表单结束-->

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th><input type="checkbox" value="" id="all"></th>
						<th class="col-md-1">序号</th>
						<th class="col-md-1">名称</th>
						<th class="col-md-8">介绍</th>
						<th class="col-md-1">讲师</th>
						<th class="col-md-1">课程</th>
						<th>时长</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="#{page.rows }" var="video" varStatus="status">
						<tr>
						<td><input name="checkName" type="checkbox" id="${video.id }"></td>
						<th scope="row">${status.count }</th>
						<td>${video.video_title }</td>
						<td>${video.video_descr }</td>
						<td>${video.speaker_name }</td>
						<td>${video.course_name }</td>
						<td>${video.video_play_times }</td>
						<td>
							<a href="${pageContext.request.contextPath }/video/editVideo.action?editid=${video.id}" class="glyphicon glyphicon-edit" style="text-decoration: none;" title="编辑"></a>
						</td>
						<td>
							<input type="hidden" id="url">
							<a onclick="delcfm('${pageContext.request.contextPath }/video/deleteVideo.action?delid=${video.id}')" class="glyphicon glyphicon-trash" style="text-decoration: none;" title="删除"></a>
						</td>
					</tr>
					</c:forEach>
				
					
					
				</tbody>
			</table>
		
		<div style="text-align: right;">
			<xs:page url="${pageContext.request.contextPath }/video/videoList.action"></xs:page>
		</div>
		
		</div>
		<!-- 页脚开始 -->
		<%@ include file="../footer.jsp" %>
		<!-- 页脚结束 -->
		
		<!-- 模态框开始（Modal） -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" id="myModalLabel">
					提示信息
				</h4>
					</div>
					<div class="modal-body">
						您确定删除吗？
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a class="btn btn-primary" onclick="urlSubmit()">确定</a>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 模态框结束（Modal） -->
		
		
		<script>
			var num = 0;
			//设置全选反选
			$("#all").click(function() {
				if(this.checked) {
					$("td :checkbox").prop("checked", true);
					num = $("input[name=checkName]:checkbox").size();
				} else {
					num=0;
					$("td :checkbox").prop("checked", false);
				}
				$("#deleteNum").html(num);
			});
			
			$("input[name=checkName]").click(function(){
				var checks = window.document.getElementsByName("checkName");
				if(this.checked){
					num++;
					if(checks.length == num){
					   $("#all").checked = true;
					}
				}else{
					$("#all").checked = false;
					num--;
				}
				$("#deleteNum").html(num);
			});
			
			function mulDelete(){
				var checks = window.document.getElementsByName("checkName");
				var url = "";
				for(var i = 0; i < checks.length; i++){
					if(checks[i].checked === true){
						url += "id="+checks[i].id + "&";						
					}
				}
				
				/* document.location = "${pageContext.request.contextPath }/video/batchDelect.action?" + url.substring(0,url.lastIndexOf('&')); */
				//alert("${pageContext.request.contextPath }/video/batchDelect.action?" + url.substring(0,url.lastIndexOf('&')));
				$('#url').val("${pageContext.request.contextPath}/video/batchDelect.action?" +url.substring(0,url.lastIndexOf('&')) ); //给会话中的隐藏属性URL赋值
				$('#deleteModal').modal();
				
			}
			
			
			/* 模态框 */
			function delcfm(url) {
				$('#url').val(url); //给会话中的隐藏属性URL赋值
				$('#deleteModal').modal();
			}

			function urlSubmit() {
				var url = $.trim($("#url").val()); //获取会话中的隐藏属性URL
				window.location.href = url;
				/* alert(url); */
			}
			
		</script>
	</body>

</html>
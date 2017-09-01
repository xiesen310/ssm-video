<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://zhiyou100.com/common/" prefix="xs"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>课程信息管理</title>
		<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.png" type="image/x-icon">
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<style>
			body{
				background-color: #e4e4e4;
			}
		</style>
	</head>

	<body>
	
	<!-- 导航栏开始 -->
	<jsp:include page="/WEB-INF/view/head.jsp">
		<jsp:param value="course" name="formjsp"/>
	</jsp:include>
	<!-- 导航栏结束 -->
	
		<div class="container">
			<!--巨幕开始-->
			<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
				<h2>课程列表-课程管理</h2>
			</div>
			<!--巨幕结束-->

			<!--添加课程开始-->
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/course/addCourse.action">添加课程</a>
			<!--添加课程结束-->

			<!--课程列表开始-->

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th class="col-md-1">序号</th>
						<th class="col-md-1">标题</th>
						<th class="col-md-1">学科</th>
						<th class="col-md-9">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.rows }" var="course" varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<td>${course.course_name}</td>
							<td>${course.subject_name }</td>
							<td>${course.course_descr }</td>
							<input type="hidden" id="url" value=""/>
							<td><a href="${pageContext.request.contextPath }/course/editCourse.action?id=${course.id}" class="glyphicon glyphicon-edit" style="text-decoration: none;" title="编辑"></a></td>
							<td><a  onclick="delcfm('${pageContext.request.contextPath }/course/deleteCourse.action?id=${course.id}')" class="glyphicon glyphicon-trash" style="text-decoration: none;" title="删除"></a></td>
						</tr>
					</c:forEach>
		
				</tbody>
			</table>

			<!--课程列表结束-->
			<!-- 分页开始 -->
			<div style="text-align: right;">
				<xs:page url="${pageContext.request.contextPath }/course/courseList.action"></xs:page>
			</div>
			<!-- 分页结束 -->

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
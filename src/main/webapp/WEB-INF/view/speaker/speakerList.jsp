<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>主讲人管理</title>
		
		<link rel="icon" href="img/favicon.png" type="image/x-icon">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js" ></script>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		
		<link href="${pageContext.request.contextPath }/css/jquery-confirm.min.css" rel="stylesheet">
		<style>
			body{
				background-color: #e4e4e4;
			}
		</style>

	</head>

	<body>
		
	<!-- 导航栏开始 -->
	<jsp:include page="/WEB-INF/view/head.jsp">
		<jsp:param value="speaker" name="formjsp"/>
	</jsp:include>
	<!-- 导航栏结束 -->
	
		<div class="container">
			<!--巨幕开始-->
			<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
				<h2>编辑主讲人-主讲人管理</h2>
			</div>
			<!--巨幕结束-->
				
				<!--搜索表单开始-->
			<form class="form-inline" action="${pageContext.request.contextPath }/speaker/selectSpeakerByNameAndJob.action">
					<!--添加主讲人开始-->
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/speaker/addSpeaker.action">添加主讲人</a>
					<!--添加主讲人结束-->
				<div class="pull-right">
				  
				  
				<div class="form-group">
					<label >名称</label>
				  <input type="text" class="form-control" name="speaker_name" placeholder="主讲人名称">		  	
				</div>
				  <div class="form-group">
					<label >职位</label>
				  <input type="text" class="form-control" name="speaker_job" placeholder="主讲人职位">		  	
				</div>
				
				<button type="submit" class="btn btn-primary">查询</button>
			</div>
				</form>
				<!--搜索表单结束-->
		
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th class="col-md-1">序号</th>
						<th class="col-md-1">名称</th>
						<th class="col-md-1">职位</th>
						<th class="col-md-9">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="speaker" items="${speakerList }" varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<td>${speaker.speaker_name }</td>
							<td>${speaker.speaker_job }</td>
							<td>${speaker.speaker_descr }</td>
							<input type="hidden" id="url" value=""/>
							<td><a href="${pageContext.request.contextPath }/speaker/editSpeaker.action?id=${speaker.id}" class="glyphicon glyphicon-edit" style="text-decoration: none;" title="编辑"></a></td>
							<td>
								<%-- <a onclick="delcfm('${pageContext.request.contextPath }/speaker/deleteSpeaker.action?id=${speaker.id}')"  class="glyphicon glyphicon-trash" style="text-decoration: none;" title="删除"></a> --%>
								<a onclick="deleteData(${speaker.id})"  class="glyphicon glyphicon-trash" style="text-decoration: none;" title="删除"></a>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
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
			
			function deleteData(id){
				//alert(id);
				$.confirm({
				    title: '提示信息',
				    content: '您确定删除吗？',
				    buttons: {
				    	确定: function () {
							window.location.href = '${pageContext.request.contextPath }/speaker/deleteSpeaker.action?id=' + id;
				    		/* $.alert('确定'); */
				        },
				       	 取消: function () {
				            /* $.alert('取消'); */
				        }
				    }
				});
			}
		</script>
		
		

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-confirm.min.js" ></script>	
		
		
		
	</body>



</html>
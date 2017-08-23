<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--导航开始-->
		<nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<a class="navbar-brand" href="#">视频管理系统</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
					<ul class="nav navbar-nav">
						<li>
							<a href="${pageContext.request.contextPath }/video/videoList.action">视频管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/speaker/speakerList.action">主讲人管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/course/courseList.action">课程管理</a>
						</li>
						<li>
							<a href="#">统计管理</a>
						</li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">${admin.loginName}</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/exitLogin.action" class="glyphicon glyphicon-log-out pull-right"></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!--导航结束-->
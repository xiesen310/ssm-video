<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<meta charset="utf-8">
<title>统计分析</title>
<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.png" type="image/x-icon">
<!-- 引入 echarts.js -->
<script src="${pageContext.request.contextPath }/js/echarts.common.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#ajax").click(function(){
			$("#main").toggle("slow");
		});
	}); 
</script>
</head>
<body>
	<!-- 导航栏开始 -->
<%-- 	<%@ include file="../head.jsp"%> --%>
	<jsp:include page="/WEB-INF/view/head.jsp">
		<jsp:param value="count" name="formjsp"/>
	</jsp:include>
	<!-- 导航栏结束 -->
	<!-- 巨幕开始 -->
	<div class="container">
		<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
			<h2>视图展示-统计分析</h2>
		</div>
	</div>
	<!-- 巨幕结束 -->
	<div class="container">
		<a class="btn btn-success" id="ajax">显示隐藏视图</a>
	</div>
	
	<div id="main" style="width: 1000px; height: 600px; margin: 0 auto;"></div>
	<!-- ajax加载开始 -->
	
	
	<!-- ajax加载结束 -->
	
	
	
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('main'));
		// 显示标题，图例和空的坐标轴
		myChart.setOption({
			title : {
				text: '课程平均播放次数',
                subtext: '数据来源：www.zhiyou100.com',
                left:'50%',
                top:'1%',
                textAlign:'center'
			},
			tooltip : {},
			legend : {
				left: 'right',
				data : [ '平均播放次数' ]
			},
			xAxis : {
				name: '科目',
				data : [${x}]
			},
			yAxis : {
				name: ['平均播放次数(times)']
			},
			series : [ {
				name : '平均播放次数',
				type : 'bar',	
				data : [${y}]
			} ]
		});

	</script>
	
	

	

	<!-- 页脚开始 -->
	<%@ include file="../footer.jsp"%>
	<!-- 页脚结束 -->
</body>
</html>
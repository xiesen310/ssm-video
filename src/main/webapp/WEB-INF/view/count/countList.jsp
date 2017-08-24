<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<meta charset="utf-8">
<title>ECharts</title>
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
	<%@ include file="../head.jsp"%>
	<!-- 导航栏结束 -->
	<!-- 巨幕开始 -->
	<div class="container">
		<div class="jumbotron" style="padding-top: 2px; padding-bottom: 30px;">
			<h2>视频列表-视频管理</h2>
		</div>
	</div>
	<!-- 巨幕结束 -->
	
	<div id="main" style="width: 1000px; height: 600px; margin: 0 auto;"></div>
	<!-- ajax加载开始 -->
	<div class="container">
		<a class="btn btn-success" id="ajax">ajax加载视图</a>
	</div>
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
				data : []
			},
			yAxis : {
				name: ['平均播放次数(times)']
			},
			series : [ {
				name : '平均播放次数',
				type : 'bar',	
				data : []
			} ]
		});

		myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

		var names = []; //类别数组（实际用来盛放X轴坐标值）
		var nums = []; //播放次数数组（实际用来盛放Y坐标值）

		$.ajax({
			type : "post",
			async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
			url : "${pageContext.request.contextPath }/count/countLists.action",
			data : {},
			dataType : "json", //返回数据形式为json
			success : function(result) {
				//请求成功时执行该函数内容，result即为服务器返回的json对象
				if (result) {
					for (var i = 0; i < result.length; i++) {
						names.push(result[i].course_name); //挨个取出类别并填入类别数组
					}
					for (var i = 0; i < result.length; i++) {
						nums.push(result[i].avg); //挨个取出销量并填入销量数组
					}
					myChart.hideLoading(); //隐藏加载动画
					myChart.setOption({ //加载数据图表
						xAxis : {
							data : names
						},
						series : [ {
							// 根据名字对应到相应的系列
							name : '平均播放次数',
							data : nums
						} ]
					});

				}

			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				alert("图表请求数据失败!");
				myChart.hideLoading();
			}
		})
	</script>

	<!-- 页脚开始 -->
	<%@ include file="../footer.jsp"%>
	<!-- 页脚结束 -->
</body>
</html>
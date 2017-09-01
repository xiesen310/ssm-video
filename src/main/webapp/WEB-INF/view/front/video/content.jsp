<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div class="intro">
	<div class="container">
		<div class="v-intro">
			<div class="left">
				<video id="videoPlayer" src="${video.video_url}" class="video-js vjs-default-skin" controls width="627" height="280"
					   poster="${video.video_image_url}" data-setup="{}">
				</video>
			</div>

			<div class="right">
				<p class="right-title">${video.video_title}</p>
				<div class="avatar">
					<span style="background-image: url(${speaker.speaker_head_url})"></span>
					<p><b>讲师：${speaker.speaker_name}</b><br><i>${speaker.speaker_descr}</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span> ${video.video_descr}
				</p>
			</div>
		</div>

		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content">${course.course_descr}</p>
		</div>

	</div>
</div>
<!--目录-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>

		<c:forEach items="${videoList}" var="video" >
			<div class="chapter">
				<p class="biaoti"><a href="/video/front/video/index.action?videoId=${video.id}&subjectId=${subjectId}">${video.video_title}</a></p>
				<p class="lecturer">${video.video_descr}</p>
				<p class="lecturer">讲师：${video.speaker_name}</p>
				<div class="v-info">
					<span class="count"><img src="<c:url value="/static/img/count.png"/>" alt="">${video.video_play_times}</span>
					<span class="duration"><img src="<c:url value="/static/img/player.png"/>" alt="">${video.video_length}</span>
				</div>
			</div>
		</c:forEach>


	</div>
</div>
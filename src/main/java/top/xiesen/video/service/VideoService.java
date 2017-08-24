package top.xiesen.video.service;


import java.util.List;

import top.xiesen.video.model.Video;
import top.xiesen.video.utils.Page;

public interface VideoService {

	Page loadPage(String video_title, String speaker_name, String course_name,int page);

	void insertVideo(Video video);

	void deleteBatch(String[] id);

	void deleteById(int delid);

	Video selectVideoById(int id);

	void updateVideo(Video video);

	List<Video> selectAllVideo();


}

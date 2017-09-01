package top.xiesen.video.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import top.xiesen.video.model.Video;

@Repository
public interface VideoMapper {

	int selectVideoCount(@Param("video_title")String video_title,@Param("speaker_name")String speaker_name,@Param("course_name")String course_name);

	List<Video> selectVideo(@Param("video_title")String video_title,@Param("speaker_name")String speaker_name,@Param("course_name")String course_name,@Param("page")int page);

	void insertVideo(Video video);

	void deleteBatch(@Param("deleteid")int deleteid);

	Video selectVideoById(int id);

	void updateVideo(Video video);

	List<Video> selectAllVideo();

    List<Video> selectVideoInId(String substring);

    List<Video> selectVideoByCourse(Integer course_id);

    void updateVideoPlayTimes(int i,int id);
}

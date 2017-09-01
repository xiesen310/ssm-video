package top.xiesen.video.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import top.xiesen.video.model.Speaker;
@Repository
public interface SpeakerMapper {
	 void addSpeaker(Speaker speaker);

	List<Speaker> selectSpeakerByNameAndJob(@Param("speaker_name")String speaker_name, @Param("speaker_job")String speaker_job);

	List<Speaker> selectAllSpeaker();

	void deleteSpeakerById(int id);

	void updateSpeakerById(Speaker speaker);

	Speaker selectSpeakerById(int id);
	
	
	
}

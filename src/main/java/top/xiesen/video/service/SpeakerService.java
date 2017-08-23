package top.xiesen.video.service;

import java.util.List;

import top.xiesen.video.model.Speaker;

public interface SpeakerService {
	void addSpeaker(Speaker speaker);

	List<Speaker> selectSpeakerByNameAndJob(String speaker_name, String speaker_job);

	List<Speaker> selectAllSpeaker();

	void deleteSpeakerById(int id);
	void updateSpeakerById(Speaker speaker);

	Speaker selectSpeakerById(int id);
}

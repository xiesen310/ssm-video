package top.xiesen.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xiesen.video.mapper.SpeakerMapper;
import top.xiesen.video.model.Speaker;
import top.xiesen.video.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService{

	@Autowired
	SpeakerMapper sm;
	
	@Override
	public void addSpeaker(Speaker speaker) {
		sm.addSpeaker(speaker);
	}

	@Override
	public List<Speaker> selectSpeakerByNameAndJob(String speaker_name, String speaker_job) {
		return sm.selectSpeakerByNameAndJob(speaker_name, speaker_job);
	}

	@Override
	public List<Speaker> selectAllSpeaker() {
		return sm.selectAllSpeaker();
	}

	@Override
	public void deleteSpeakerById(int id) {
		sm.deleteSpeakerById(id);
	}

	@Override
	public void updateSpeakerById(Speaker speaker) {
		sm.updateSpeakerById(speaker);
		
	}

	@Override
	public Speaker selectSpeakerById(int id) {
		return sm.selectSpeakerById(id);
	}



}

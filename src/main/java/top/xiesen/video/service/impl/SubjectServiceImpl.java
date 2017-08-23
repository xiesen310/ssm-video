package top.xiesen.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xiesen.video.mapper.SubjectMapper;
import top.xiesen.video.model.Subject;
import top.xiesen.video.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectMapper sm;

	
	@Override
	public List<Subject> selectAllSubject() {
		return sm.selectAllSubject();
	}

}

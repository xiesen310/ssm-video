package top.xiesen.video.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.xiesen.video.model.Admin;
import top.xiesen.video.model.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml"})
public class TestSubjectService {

	@Autowired
	SubjectService ss;
	

	@Test
	public void testAdmin(){
		List<Subject> list = ss.selectAllSubject();
		for (Subject subject : list) {
			System.out.println(subject);
		}
	}
}


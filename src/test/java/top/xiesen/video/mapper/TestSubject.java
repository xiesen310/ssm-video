package top.xiesen.video.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import top.xiesen.video.model.Admin;
import top.xiesen.video.model.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TestSubject {

	@Autowired
	SubjectMapper sm;
	@Test
	public void testAdmin(){
		List<Subject> list = sm.selectAllSubject();
		for (Subject subject : list) {
			System.out.println(subject);
		}
	}
}

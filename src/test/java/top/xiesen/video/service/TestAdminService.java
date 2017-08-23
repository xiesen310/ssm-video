package top.xiesen.video.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.xiesen.video.model.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestAdminService {

	@Autowired
	AdminService as;
	
	@Test
	public void testAdmin(){
		Admin login = as.login("admin", "admin");
		System.out.println(login);
	}
}


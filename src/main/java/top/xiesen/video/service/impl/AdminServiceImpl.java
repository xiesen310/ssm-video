package top.xiesen.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import top.xiesen.video.mapper.AdminMapper;
import top.xiesen.video.model.Admin;
import top.xiesen.video.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper am;
	
	@Override
	public Admin login(String username, String password) {
		return am.login(username, DigestUtils.md5DigestAsHex(password.getBytes()));
	}

}

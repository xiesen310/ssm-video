package top.xiesen.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiesen.video.mapper.UserMapper;
import top.xiesen.video.model.User;
import top.xiesen.video.service.UserService;
import top.xiesen.video.utils.MailUtil;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper um;

	@Override
	public boolean regist(User user) {
		if(um.selectUserByEmail(user.getEmail())==null){
//			System.out.println("regist......service");
			um.regist(user);
			return true;
		}
		return false;
	}



	@Override
	public User doLogin(User user) {
		if(um.selectUserByEmail(user.getEmail())==null){
			return null;
		}
		return um.login(user);
	}

	@Override
	public boolean sendemail(User user) {
		if(um.selectUserByEmail(user.getEmail())==null){
			return false;
		}
		String capcha =  MailUtil.createRandom();
		user.setCaptcha(capcha);
		// 发送邮件
		try {
			MailUtil.send(user.getEmail(),"智游在线公开课","智游在线公开课找回密码，您的验证码信息是：" + capcha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		um.updateBymail(user);
		return true;
	}

	@Override
	public User selectUserByEmail(String email) {
		return um.selectUserByEmail(email);
	}

	@Override
	public String selectCaptcha(User user) {
		return um.selectCaptcha(user);
	}

	@Override
	public void updatePwd(User user) {
		um.updatePwd(user);
	}

	@Override
	public void updateProfile(User user) {
		user.setUpdate_time(new Date(System.currentTimeMillis()));
		um.updateProfile(user);
	}

	@Override
	public String selectUserPassword(String email) {
		return um.selectUserPassword(email);
	}

	@Override
	public void updatePassword(String s,String email) {
		um.updatePassword(s,email);
	}

	@Override
	public void updateHeadUrl(String fileName,String email) {
		um.updateHeadUrl(fileName,email);
	}
}

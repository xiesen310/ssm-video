package top.xiesen.video.service;

import top.xiesen.video.model.User;

public interface UserService {

	boolean regist(User user);
	User doLogin(User user);
	boolean sendemail(User user);
	User selectUserByEmail(String email);
	String selectCaptcha(User user);

	void updatePwd(User user);

	void updateProfile(User user);

	String selectUserPassword(String email);

	void updatePassword(String s,String email);

	void updateHeadUrl(String fileName,String email);
}

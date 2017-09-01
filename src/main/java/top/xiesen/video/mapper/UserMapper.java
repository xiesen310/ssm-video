package top.xiesen.video.mapper;


import org.apache.ibatis.annotations.Param;
import top.xiesen.video.model.Admin;
import top.xiesen.video.model.User;

public interface UserMapper {
	void regist(User user);
	User selectUserByEmail(String email);
	User login(User user);
	void updateBymail(User user);

	String selectCaptcha(User user);

	void updatePwd(User user);

    void updateProfile(User user);

	String selectUserPassword(String email);

	void updatePassword(String s,String email);

	void updateHeadUrl(String fileName,String email);
}

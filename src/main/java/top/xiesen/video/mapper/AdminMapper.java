package top.xiesen.video.mapper;


import org.apache.ibatis.annotations.Param;

import top.xiesen.video.model.Admin;

public interface AdminMapper {
	Admin login(@Param("loginName")String loginName,@Param("loginPwd")String loginPwd);
}

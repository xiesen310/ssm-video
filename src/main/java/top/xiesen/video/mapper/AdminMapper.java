package top.xiesen.video.mapper;


import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import top.xiesen.video.model.Admin;

@Repository
public interface AdminMapper {
	Admin login(@Param("loginName")String loginName,@Param("loginPwd")String loginPwd);
}

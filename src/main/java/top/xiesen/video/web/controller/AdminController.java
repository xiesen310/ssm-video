package top.xiesen.video.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.xiesen.video.model.Admin;
import top.xiesen.video.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService as;
	
	@RequestMapping("/login.action")
	public String login(){
		return "admin/login";
	}
	@RequestMapping(value="/dologin.action",method=RequestMethod.POST)
	public String doLogin(String username,String password,HttpSession session){
		Admin admin = as.login(username, password);
		if(admin != null){
			session.setAttribute("admin", admin);
			return "forward:/video/videoList.action";
		}
		
		return "admin/login";
	}
	@RequestMapping(value="/exitLogin.action")
	public String exitLogin(HttpSession session){
		session.invalidate();
		return "admin/login";
	}
}

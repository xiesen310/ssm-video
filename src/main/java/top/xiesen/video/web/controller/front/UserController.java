package top.xiesen.video.web.controller.front;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.xiesen.video.model.Data;
import top.xiesen.video.model.Result;
import top.xiesen.video.model.User;
import top.xiesen.video.service.UserService;
import top.xiesen.video.utils.MD5Utils;
import top.xiesen.video.utils.MailUtil;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.util.UUID;

/**
 * 前台用户控制器
 */
@Controller
@RequestMapping("/front/user")
public class UserController {

    @Autowired
    UserService userService;
    /*登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user, HttpSession session){
        Result result = new Result();
        User user1 = userService.doLogin(user);
        result.setSuccess(user1 == null ? false:true);
        session.setAttribute("_front_user",user1);
        session.setAttribute("user",user1);
        result.setMessage("用户名或密码错误");
        return result;
    }

    /*注册*/
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Result regist(User user){
//        System.out.println("regist......开始了");
        user.setInsert_time(new Date(System.currentTimeMillis()));

        Result result = new Result();
        result.setMessage("该邮箱已经被注册");
        result.setSuccess(userService.regist(user));
//        System.out.println("regist.............执行完成");
        return result;
    }

    /*退出*/
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/front/toIndex.action";
    }

    /*跳入忘记密码页面*/
    @RequestMapping("/forgetpwd")
    public String toForgetpwd(){
        return "front/user/forget_pwd";
    }
    // 提交验证信息
    @RequestMapping(value = "/forgetpwd",method = RequestMethod.POST)
    public String doForgetpwd(User user, Model model){
        String captcha = userService.selectCaptcha(user);
        if(captcha.equals(user.getCaptcha())&& user.getEmail()==null){
            model.addAttribute("email",user.getEmail());
            model.addAttribute("captcha",user.getCaptcha());
            return "front/user/reset_pwd";
        }
        model.addAttribute("message","Email或验证码不正确，请重新输入");
        return "/front/user/forget_pwd";
    }
    // 发送邮件
    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    @ResponseBody
    public Data sendemail(User user){
        Data data = new Data();
        data.setMessage("该邮箱未注册");
        data.setSuccess(userService.sendemail(user));
        return data;
    }

    // 修改密码
    @RequestMapping(value = "/resetpwd",method = RequestMethod.POST)
    public String reser_pwd(User user){
        userService.updatePwd(user);
        return "redirect:/front/toIndex.action";
    }

    // 跳转到修改信息界面
    @RequestMapping("/index")
    public String index(){
        return "/front/user/index";
    }

    // 跳转到更新资料页面
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String profile(){
        return "/front/user/profile";
    }

    // 更新资料页面
    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String doProfile(User user){
        userService.updateProfile(user);
        return "/front/user/index";
    }

    // 跳转到密码安全页面
    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String password(){
        return "/front/user/password";
    }
    // 跳转到密码安全页面
    @RequestMapping(value = "/password",method = RequestMethod.POST)
    public String doPassword(String email,String oldPassword,String newPassword){
        String str = userService.selectUserPassword(email);
        if(str.equals(MD5Utils.MD5Encrypt(oldPassword))){
            userService.updatePassword(MD5Utils.MD5Encrypt(newPassword),email);
            return "redirect:/front//user/logout.action";
        }
        return "/front/user/password";
    }

    /*重置*/
    @RequestMapping("/resetting")
    public String resetting(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "front/user/profile";
    }

    /*跳转更改头像*/
    @RequestMapping(value = "/avatar",method = RequestMethod.GET)
    public String toAvatar(){
        return "front/user/avatar";
    }
    /*图像上传操作*/
    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public String doAvatar(String email,MultipartFile image_file) throws Exception{
        // 产生随机的名字
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取图像的后缀名
        String extension = FilenameUtils.getExtension(image_file.getOriginalFilename());
        // 拼接新起的图片名
        String fileName = str + "." + extension;
        // 设置图像上传后的路径，D:\IDEA\project\ssm-video\videoPic
        String path = "D:\\IDEA\\project\\ssm-video\\videoPic";
        // 拼接成图片访问路径
        image_file.transferTo(new File(path + "\\" + fileName));

        // 数据库更新
        userService.updateHeadUrl(fileName,email);
        // 跳转页面
        return "front/user/index";
    }


}

package top.xiesen.video.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台首页
 */
@Controller
@RequestMapping("/front")
public class FrontIndex {
    @RequestMapping("/toIndex.action")
    public String toIndex(){
        return "front/index";
    }
}

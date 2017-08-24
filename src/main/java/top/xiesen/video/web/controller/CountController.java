package top.xiesen.video.web.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import top.xiesen.video.model.Video;
import top.xiesen.video.service.VideoService;

@Controller
@RequestMapping("/count")
public class CountController {

	@Autowired
	VideoService vs;

	@RequestMapping("/countList.action")
	public  String count(Model model,HttpServletResponse response) throws IOException {
		 
        
		return "count/countList";
	}
	
	@RequestMapping(value="/countLists.action",method=RequestMethod.POST)
	public  void counts(Model model,HttpServletResponse response) throws IOException {
		
		List<Video> videoList = vs.selectAllVideo();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(videoList);
		//将json数据返回给客户端
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);  
        System.out.println("json数据："+json);
		
	}
}

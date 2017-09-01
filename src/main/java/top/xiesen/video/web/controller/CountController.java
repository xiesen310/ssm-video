package top.xiesen.video.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import top.xiesen.video.model.Video;
import top.xiesen.video.service.VideoService;

@Controller
@RequestMapping("/count")
public class CountController {

	@Autowired
	VideoService vs;

	@RequestMapping("/countList.action")
	public  String count(Model model) throws IOException {
		List<Video> videoList = vs.selectAllVideo();
		StringBuilder x = new StringBuilder();
		StringBuilder y = new StringBuilder();

		for (Video video : videoList) {
			x.append("'"+video.getCourse_name()+"',");
			y.append(video.getAvg()+",");
		}
		
		model.addAttribute("x", x.deleteCharAt(x.length()-1));
		model.addAttribute("y", y.deleteCharAt(y.length()-1));
        
		return "count/countList";
	}
	
	@RequestMapping(value="/countLists.action")
	public  void counts(Model model,HttpServletResponse response) throws IOException {
		
		List<Video> videoList = vs.selectAllVideo();
		for (Video video : videoList) {
			System.out.println("videoList: " + video);
		}
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(videoList);
		//将json数据返回给客户端
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);  
        //System.out.println("json数据："+json);
	}
}

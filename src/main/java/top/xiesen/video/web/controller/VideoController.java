package top.xiesen.video.web.controller;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import top.xiesen.video.model.Course;
import top.xiesen.video.model.Speaker;
import top.xiesen.video.model.Subject;
import top.xiesen.video.model.Video;
import top.xiesen.video.service.CourseService;
import top.xiesen.video.service.SpeakerService;
import top.xiesen.video.service.SubjectService;
import top.xiesen.video.service.VideoService;
import top.xiesen.video.utils.Page;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService subject;
	
	@RequestMapping("/videoList.action")
	public String videoList(String video_title, String speaker_name, String course_name,Model model,
			@RequestParam(defaultValue="1")int page){
		
		@SuppressWarnings("rawtypes")
		Page pages = vs.loadPage(video_title,speaker_name,course_name,page);
		model.addAttribute("page", pages);
		
		List<Speaker> speakerList = ss.selectAllSpeaker();
		model.addAttribute("speakerList", speakerList);
		
		List<Course> courseList = cs.selectAllCourse();
		model.addAttribute("courseList", courseList);
		return "video/videoList";
	}
	
	@RequestMapping("/addVideo.action")
	public String addVideo(Model model){
		List<Speaker> speaker = ss.selectAllSpeaker();
		model.addAttribute("speakerList", speaker);
		
		List<Subject> subjectList = subject.selectAllSubject();
		model.addAttribute("subjectList", subjectList);
		
		return "video/addVideo";
	}
	
	@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	public String doAddVideo(Video video){
		video.setInsert_time(new Date(System.currentTimeMillis()));
		vs.insertVideo(video);
		return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/batchDelect.action")
	public String batchDelect(String[] id){
		
		vs.deleteBatch(id);
		return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/deleteVideo.action")
	public String deleteVideo(int delid){
		vs.deleteById(delid);
		return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/editVideo.action")
	public String editVideo(Model model,int editid){
		List<Speaker> speakerList = ss.selectAllSpeaker();
		model.addAttribute("speakerList", speakerList);
		List<Course> courseList = cs.selectAllCourse();
		model.addAttribute("courseList", courseList);
		
		Video video = vs.selectVideoById(editid);
		model.addAttribute("video", video);
		
		return "/video/editVideo";
	}
	@RequestMapping(value="/editVideo.action",method=RequestMethod.POST)
	public String doEditVideo(Video video ){
		System.out.println("演讲人id ： "+video.getSpeaker_id());
		video.setUpdate_time(new Date(System.currentTimeMillis()));
		vs.updateVideo(video);
		
		return "redirect:/video/videoList.action";
	}
	
	
	
}

package top.xiesen.video.web.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xiesen.video.model.Course;
import top.xiesen.video.model.Speaker;
import top.xiesen.video.model.Subject;
import top.xiesen.video.model.Video;
import top.xiesen.video.service.CourseService;
import top.xiesen.video.service.SpeakerService;
import top.xiesen.video.service.SubjectService;
import top.xiesen.video.service.VideoService;

import java.util.List;

/**
 * 课程控制器
 */
@Controller
@RequestMapping("/front/video")
public class FrontVideoController {

    @Autowired
    SubjectService subjectService;
    @Autowired
    VideoService videoService;
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/index")
    public String index(String videoId,String subjectId, Model model){
        Subject subject = subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject",subject);
        model.addAttribute("videoId",videoId);
        return "/front/video/index";
    }

    @RequestMapping("/videoData")
    public String videoData(String videoId,Model model){
        Video video = videoService.selectVideoById(Integer.parseInt(videoId));

//        System.out.println("视频对象讲师id："+video.getSpeaker_id());
        model.addAttribute("video",video);
        Speaker speaker = speakerService.selectSpeakerById(video.getSpeaker_id());
//        System.out.println("讲师： "+speaker);
        model.addAttribute("speaker",speaker);
        Course course = courseService.selectCourseById(video.getCourse_id());
        model.addAttribute("course",course);

        List<Video> videoList = videoService.selectVideoByCourse(video.getCourse_id());
        model.addAttribute("videoList",videoList);

        return "/front/video/content";
    }

    ////播放量统计,不需要返回结果处理
    @RequestMapping("/state")
    public void state(String videoId){
        Video video = videoService.selectVideoById(Integer.parseInt(videoId));
        System.out.println("videoId: " + videoId);
        Integer video_play_times = video.getVideo_play_times();
        videoService.updateVideoPlayTimes(video_play_times+1,Integer.parseInt(videoId));
    }

}

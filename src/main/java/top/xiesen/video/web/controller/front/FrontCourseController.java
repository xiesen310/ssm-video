package top.xiesen.video.web.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xiesen.video.model.Course;
import top.xiesen.video.model.Subject;
import top.xiesen.video.model.Video;
import top.xiesen.video.service.CourseService;
import top.xiesen.video.service.SubjectService;
import top.xiesen.video.service.VideoService;
import top.xiesen.video.utils.DateTransform;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 前端课程控制器
 */
@Controller
@RequestMapping("/front/course")
public class FrontCourseController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseService courseService;

    @RequestMapping("/index")
    public String index(String subjectId, Model model){
        /*科目*/
        Subject subject= subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject",subject);
        model.addAttribute("subject_id",subjectId);
        /*课程*/
        List<Course> course = courseService.selectCourseBySubjectId(Integer.parseInt(subjectId));
        model.addAttribute("courses",course);

        return "front/course/index";
    }

}

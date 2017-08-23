package top.xiesen.video.web.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.xiesen.video.model.Course;
import top.xiesen.video.model.Subject;
import top.xiesen.video.service.CourseService;
import top.xiesen.video.service.SubjectService;
import top.xiesen.video.utils.Page;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService cs;
	
	@Autowired
	SubjectService subject;

	@RequestMapping("/courseList.action")
	public String courseList(HttpServletRequest requset){
		int currentPage = requset.getParameter("page") == null ? 1 : Integer.parseInt(requset.getParameter("page"));
		Page page = cs.loadPage(currentPage);
		
		requset.setAttribute("page",page);
		return "course/courseList";
	}
	
	@RequestMapping(value="/addCourse.action")
	public String addCourse(HttpServletRequest request){
		List<Subject> subjectList = subject.selectAllSubject();
		request.setAttribute("subject", subjectList);
		return "course/addCourse";
	}
	@RequestMapping(value = "/addCourses.action")
	public String doAddCourse(String subject_id,String course_name,String course_descr){
		Course course = new Course();
		course.setSubject_id(Integer.parseInt(subject_id));
		course.setCourse_name(course_name);
		course.setCourse_descr(course_descr);
		course.setInsert_time(new Date(System.currentTimeMillis()));
		cs.insertCourse(course);
		return "redirect:/course/courseList.action";
	}
	
	@RequestMapping("/deleteCourse.action")
	public String deleteCourse(int id){
		cs.deleteCourseById(id);
		return "redirect:/course/courseList.action";
	}
	@RequestMapping("/editCourse.action")
	public String editCourse(int id,Model model){
		Course course =  cs.selectCourseById(id);
		List<Course> subject = cs.selectAllCourseBySubject();
		model.addAttribute("subject", subject);
		model.addAttribute("course", course);
		return "/course/editCourseList";
	}
	
	@RequestMapping(value="/editCourse.action",method=RequestMethod.POST)
	public String doEditCourse(int id,int subject_id,String course_name,String course_descr,Model model){
		Course course = new Course();
		course.setId(id);
		course.setSubject_id(subject_id);
		course.setCourse_descr(course_descr);
		course.setCourse_name(course_name);
		course.setUpdate_time(new Date(System.currentTimeMillis()));
		cs.updateCourse(course);
		
		return "redirect:/course/courseList.action";
	}
}

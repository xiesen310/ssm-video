package top.xiesen.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xiesen.video.mapper.CourseMapper;
import top.xiesen.video.model.Course;
import top.xiesen.video.service.CourseService;
import top.xiesen.video.utils.Page;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> selectAllCoursePage(int currentPage) {
		return cm.selectAllCoursePage(currentPage);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(int currentPage) {
		Page<Course> page = new Page<>();
		page.setPage(currentPage);
		page.setRows(cm.selectAllCoursePage((currentPage-1)*5));
		page.setSize(5);
		page.setTotal(cm.selectAllCoursePageCount());
		return page;
	}

	@Override
	public List<Course> selectAllCourseBySubject() {
		return cm.selectAllCourseBySubject();
	}

	@Override
	public void insertCourse(Course course) {
		cm.insertCourse(course);
	}

	@Override
	public void deleteCourseById(int id) {
		cm.deleteCourseById(id);
	}

	@Override
	public Course selectCourseById(int id) {
		return cm.selectCourseById(id);
	}

	@Override
	public void updateCourse(Course course) {
		cm.updateCourse(course);
	}

	@Override
	public List<Course> selectAllCourse() {
		return cm.selectAllCourse();
	}

	@Override
	public List<Course> selectCourseBySubjectId(int i) {
		List<Course> courses = cm.selectCourseBySubjectId(i);
		System.out.println(courses);
		return courses;
	}
}

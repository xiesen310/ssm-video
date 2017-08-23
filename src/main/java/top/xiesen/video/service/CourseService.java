package top.xiesen.video.service;

import java.util.List;

import top.xiesen.video.model.Course;
import top.xiesen.video.utils.Page;

public interface CourseService {
	List<Course> selectAllCoursePage(int currentPage);

	Page loadPage(int currentPage);

	List<Course> selectAllCourseBySubject();

	void insertCourse(Course course);

	void deleteCourseById(int id);

	Course selectCourseById(int id);

	void updateCourse(Course course);

	List<Course> selectAllCourse();
}

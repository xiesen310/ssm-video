package top.xiesen.video.mapper;

import java.util.List;

import top.xiesen.video.model.Course;

public interface CourseMapper {

	List<Course> selectAllCoursePage(int currentPage);

	int selectAllCoursePageCount();

	List<Course> selectAllCourseBySubject();

	void insertCourse(Course course);

	void deleteCourseById(int id);

	Course selectCourseById(int id);

	void updateCourse(Course course);

	List<Course> selectAllCourse();
}

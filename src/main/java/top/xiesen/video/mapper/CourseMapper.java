package top.xiesen.video.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import top.xiesen.video.model.Course;
@Repository
public interface CourseMapper {

	List<Course> selectAllCoursePage(int currentPage);

	int selectAllCoursePageCount();

	List<Course> selectAllCourseBySubject();

	void insertCourse(Course course);

	void deleteCourseById(int id);

	Course selectCourseById(int id);

	void updateCourse(Course course);

	List<Course> selectAllCourse();

    List<Course> selectCourseBySubjectId(int i);
}

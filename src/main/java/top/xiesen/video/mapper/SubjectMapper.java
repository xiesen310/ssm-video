package top.xiesen.video.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import top.xiesen.video.model.Subject;
@Repository
public interface SubjectMapper {

	List<Subject> selectAllSubject();

    Subject selectSubjectById(String subjectId);
}

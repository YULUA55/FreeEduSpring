package free.edu.demo.repository;



import free.edu.demo.entities.Course;
import free.edu.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseId(Long id);

    List<Course> findAllByTeacher(Teacher teacher);

}

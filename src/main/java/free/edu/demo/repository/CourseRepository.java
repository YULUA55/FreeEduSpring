package free.edu.demo.repository;



import free.edu.demo.entities.Course;
import free.edu.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseId(Long id);

    List<Course> findAllByTeacher(Teacher teacher);

    @Query("SELECT c FROM Course c JOIN c.students s ON(:studentId = s.studentId)")
    List<Course> findAllByStudent(@Param("studentId")Long studentId);

}

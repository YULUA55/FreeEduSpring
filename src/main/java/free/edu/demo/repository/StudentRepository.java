package free.edu.demo.repository;



import free.edu.demo.entities.Course;
import free.edu.demo.entities.Student;
import free.edu.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(Long id);

    @Query("SELECT s FROM Student s JOIN s.courses c ON(:course = c.courseId)")
    List<Student> findAllByCourse(@Param("course") Long courseId);

    Student findByEmail(String email);
}

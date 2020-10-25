package free.edu.demo.repository;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Lesson findByLessonId(Long id);
    List<Lesson> findAllByCourse(Course course);

    @Query("SELECT l FROM Teacher t JOIN t.courses c ON (:teacherId = c.teacher) JOIN c.lessons l ON (c = l.course)")
    List<Lesson> findAllByTeacher(@Param("teacherId") Teacher teacher);

    @Query("SELECT l FROM Course c JOIN c.students s ON (:studentId = s.studentId) JOIN c.lessons l ON (c = l.course)")
    List<Lesson> findAllByStudent(@Param("studentId") Long studentId);
}

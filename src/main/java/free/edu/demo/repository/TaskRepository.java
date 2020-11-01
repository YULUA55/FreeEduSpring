package free.edu.demo.repository;


import free.edu.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTaskId(Long id);

    List<Task> findAllByLesson(Lesson lesson);

    @Query("SELECT t FROM Course c JOIN c.lessons l ON (:course = l.course) JOIN l.tasks t ON (l = t.lesson)")
    List<Task> findAllByCourse(@Param("course") Course course);

    @Query("SELECT t FROM Course c JOIN c.lessons l ON (:course = l.course) JOIN l.tasks t ON (l = t.lesson) JOIN t.solutions s ON(:student = s.student)")
    List<Task> findAllDoneByCourseAndStudent(@Param("course")  Course course, @Param("student") Student student);

    @Query("SELECT t FROM Course c JOIN c.lessons l ON (:course = l.course) JOIN l.tasks t ON (l = t.lesson) JOIN t.solutions s ON (:student <> s.student)")
    List<Task> findAllNotDoneByCourseAndStudent(@Param("course")  Course course, @Param("student") Student student);

}

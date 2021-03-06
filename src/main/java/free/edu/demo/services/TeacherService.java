package free.edu.demo.services;

import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Teacher;
import free.edu.demo.repository.CourseRepository;
import free.edu.demo.repository.LessonRepository;
import free.edu.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository, LessonRepository lessonRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
    }


    public Teacher getTeacherById(Long id) {

        return teacherRepository.findByTeacherId(id);
    }

    public List<Course> getTeacherCourses(Long teacherId) {
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);
        return courseRepository.findAllByTeacher(teacher);
    }

    public void addTeacher(Teacher teacher) {

        teacherRepository.save(teacher);
    }

    public void addCourse(Course course) {
        System.out.println(course.getName() + course.getDescription());
        courseRepository.save(course);
    }

    public List<Lesson> getSchedule(Long teacherId) {
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);
        return lessonRepository.findAllByTeacher(teacher);
    }

}

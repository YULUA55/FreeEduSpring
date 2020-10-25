package free.edu.demo.services;

import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Student;
import free.edu.demo.entities.Task;
import free.edu.demo.repository.CourseRepository;
import free.edu.demo.repository.LessonRepository;
import free.edu.demo.repository.StudentRepository;
import free.edu.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository, LessonRepository lessonRepository, TaskRepository taskRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.taskRepository = taskRepository;
        this.studentRepository = studentRepository;
    }

    public Course getCourse(Long id) {

        return courseRepository.findByCourseId(id);
    }

    public List<Lesson> getAllLessonByCourse(Course course) {

        return lessonRepository.findAllByCourse(course);
    }


    public void addLesson(Lesson lesson) {

        lessonRepository.save(lesson);
    }

    public List<Task> getTasksByCourse(Course course) {

        return taskRepository.findAllByCourse(course);
    }

    public List<Student> getStudentsByCourse(Long courseId) {

        return studentRepository.findAllByCourse(courseId);
    }


    public List<Student> getStudents(Long id) {
        return studentRepository.findAllByCourse(id);
    }

}

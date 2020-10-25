package free.edu.demo.services;

import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Student;
import free.edu.demo.repository.CourseRepository;
import free.edu.demo.repository.LessonRepository;
import free.edu.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private LessonRepository lessonRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
    }

    public Student getStudentById(Long id) {

        return studentRepository.findByStudentId(id);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void addStudent(Student student) {

        studentRepository.save(student);
    }

    public void addCourse(Long studentId, Long courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        Student student = studentRepository.findByStudentId(studentId);
        student.getCourses().add(course);
        studentRepository.save(student);

    }

    public List<Course> getCoursesByStudent(Long studentId) {
        return courseRepository.findAllByStudent(studentId);
    }

    public List<Lesson> getSchedule(Long studentId) {
        return lessonRepository.findAllByStudent(studentId);
    }

}

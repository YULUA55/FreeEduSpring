package free.edu.demo.services;

import free.edu.demo.entities.Course;
import free.edu.demo.entities.Student;
import free.edu.demo.repository.CourseRepository;
import free.edu.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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

}

package free.edu.demo.services;

import free.edu.demo.entities.*;
import free.edu.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private LessonRepository lessonRepository;
    private SolutionRepository solutionRepository;
    private TaskRepository taskRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, LessonRepository lessonRepository, SolutionRepository solutionRepository, TaskRepository taskRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.solutionRepository = solutionRepository;
        this.taskRepository = taskRepository;
    }

    public Student getStudentById(Long studentId) {

        return studentRepository.findByStudentId(studentId);
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

    public void addSolution(Long studentId, Long taskId, String answer) {
        Student student = studentRepository.findByStudentId(studentId);
        Task task = taskRepository.findByTaskId(taskId);
        Solution solution = new Solution(answer, student, task);
        solutionRepository.save(solution);
    }

    public List<Solution> getAllSolutions(Long studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        return solutionRepository.findAllByStudent(student);
    }


    public List<Course> getCoursesByStudent(Long studentId) {
        return courseRepository.findAllByStudent(studentId);
    }

    public List<Lesson> getSchedule(Long studentId) {

        return lessonRepository.findAllByStudent(studentId);
    }

    public List<Task> getDoneTasks(Long courseId, Long studentId){
        Course course = courseRepository.findByCourseId(courseId);
        Student student = studentRepository.findByStudentId(studentId);
        return taskRepository.findAllDoneByCourseAndStudent(course,student);
    }

    public List<Task> getNotDoneTasks(Long courseId, Long studentId){
        Course course = courseRepository.findByCourseId(courseId);
        Student student = studentRepository.findByStudentId(studentId);
        return taskRepository.findAllNotDoneByCourseAndStudent(course,student);
    }




}

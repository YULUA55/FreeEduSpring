package free.edu.demo.controller;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Student;
import free.edu.demo.model.ListOfLessonsModel;
import free.edu.demo.model.StudentModel;
import free.edu.demo.model.ListOfCoursesModel;
import free.edu.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentActionController {

    private final StudentService studentService;

    public StudentActionController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    @PostMapping(value = "/createStudent")
    public void addStudent(@RequestBody StudentModel receivedStudent) {
        Student student = new Student(receivedStudent.getName(), receivedStudent.getSurname(), receivedStudent.getEmail());
        studentService.addStudent(student);
    }

    @CrossOrigin
    @GetMapping(value = "/addCourse")
    public void addCourse(@RequestParam Long id, Long courseId) {
        studentService.addCourse(id, courseId);
    }

    @CrossOrigin
    @GetMapping(value = "/courses")
    public ListOfCoursesModel getCourse(@RequestParam Long id) {
        List<Course> courses = studentService.getCoursesByStudent(id);
        return new ListOfCoursesModel(courses);
    }

    @CrossOrigin
    @GetMapping(value = "/schedule")
    public ListOfLessonsModel getSchedule(@RequestParam Long id) {
        List<Lesson> lessons = studentService.getSchedule(id);
        return new ListOfLessonsModel(lessons);
    }

}

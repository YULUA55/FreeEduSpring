package free.edu.demo.controller;


import free.edu.demo.entities.Student;
import free.edu.demo.entities.Teacher;
import free.edu.demo.model.StudentModel;
import free.edu.demo.model.TeacherModel;
import free.edu.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

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
        Student student = new Student(receivedStudent.getName(),receivedStudent.getSurname(),receivedStudent.getEmail());
        studentService.addStudent(student);
    }

    @CrossOrigin
    @GetMapping(value = "/addCourse")
    public void addCourse(@RequestParam Long id, Long courseId){
        studentService.addCourse(id,courseId);
    }

}

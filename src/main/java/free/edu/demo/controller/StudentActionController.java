package free.edu.demo.controller;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Solution;
import free.edu.demo.entities.Student;
import free.edu.demo.model.*;
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
    public void addCourse(@RequestParam Long studentId, Long courseId) {

        studentService.addCourse(studentId, courseId);
    }

    @CrossOrigin
    @GetMapping(value = "/courses")
    public ListOfCoursesModel getCourse(@RequestParam Long studentId) {
        List<Course> courses = studentService.getCoursesByStudent(studentId);
        return new ListOfCoursesModel(courses);
    }

    @CrossOrigin
    @GetMapping(value = "/schedule")
    public ListOfLessonsModel getSchedule(@RequestParam Long studentId) {
        List<Lesson> lessons = studentService.getSchedule(studentId);
        return new ListOfLessonsModel(lessons);
    }

    @CrossOrigin
    @PostMapping(value = "/addSolution")
    public void addSolution(@RequestBody SolutionModel solutionModel) {
        studentService.addSolution(solutionModel.getStudentId(), solutionModel.getTaskId(), solutionModel.getAnswer());
    }

    @CrossOrigin
    @GetMapping(value = "/allSolutions")
    public ListOfSolutionsModel getAllSolutions(@RequestParam Long studentId) {
        List<Solution> solutions = studentService.getAllSolutions(studentId);
        return new ListOfSolutionsModel(solutions);
    }


}

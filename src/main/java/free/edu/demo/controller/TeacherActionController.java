package free.edu.demo.controller;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Teacher;
import free.edu.demo.model.*;
import free.edu.demo.services.SolutionService;
import free.edu.demo.services.TeacherService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherActionController {


    private final TeacherService teacherService;
    private final SolutionService solutionService;

    public TeacherActionController(TeacherService teacherService, SolutionService solutionService) {
        this.teacherService = teacherService;
        this.solutionService = solutionService;
    }

    @CrossOrigin
    @GetMapping(value = "/getTeacher")
    public TeacherModel getTeacher(@RequestParam Long teacherId) {
        System.out.println("someone");
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return new TeacherModel(teacher.getName(), teacher.getSurname(), teacher.getEmail());
    }


    @CrossOrigin
    @GetMapping(value = "/courses")
    public ListOfCoursesModel getCourses(@RequestParam Long teacherId) {
        List<Course> courses = teacherService.getTeacherCourses(teacherId);
        return new ListOfCoursesModel(courses);
    }

    @CrossOrigin
    @GetMapping(value = "/schedule")
    public ListOfLessonsModel getLessons(@RequestParam Long teacherId) {
        List<Lesson> lessons = teacherService.getSchedule(teacherId);
        return new ListOfLessonsModel(lessons);
    }

    @CrossOrigin
    @PostMapping(value = "/createTeacher")
    public void addTeacher(@RequestBody TeacherModel receivedTeacher) {
        Teacher teacher = new Teacher(receivedTeacher.getName(), receivedTeacher.getSurname(), receivedTeacher.getEmail());
        teacherService.addTeacher(teacher);
    }

    @CrossOrigin
    @PostMapping(value = "/createCourse")
    public void addCourseByTeacher(@RequestBody CourseModel receivedCourse) {
        Teacher teacher = teacherService.getTeacherById(receivedCourse.getTeacherId());
        Course course = new Course(receivedCourse.getName(), receivedCourse.getDescription(), teacher);
        teacherService.addCourse(course);
    }

    @CrossOrigin
    @PutMapping(value = "/rateSolution")
    public void rateWork(@RequestBody MarkModel markModel) {
        solutionService.updateMark(markModel.getSolutionId(), markModel.getMark());
    }

}




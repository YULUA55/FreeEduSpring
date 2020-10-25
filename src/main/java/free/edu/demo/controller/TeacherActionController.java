package free.edu.demo.controller;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Teacher;
import free.edu.demo.model.CourseModel;
import free.edu.demo.model.TeacherCoursesModel;
import free.edu.demo.model.CourseLessonsModel;
import free.edu.demo.model.TeacherModel;
import free.edu.demo.services.TeacherService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherActionController {


    private final TeacherService teacherService;

    public TeacherActionController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @CrossOrigin
    @GetMapping(value = "/courses")
    public TeacherCoursesModel getCourses(@RequestParam Long teacherId) {
        System.out.println("Кто-то здесь");
        Teacher teacher = teacherService.getTeacherById(teacherId);
        List<Course> courses = teacherService.getTeacherCourses(teacher);
        return new TeacherCoursesModel(courses);
    }

    @CrossOrigin
    @GetMapping(value = "/schedule")
    public CourseLessonsModel getLessons(@RequestBody Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        List<Lesson> lessons = teacherService.getSchedule(teacher);
        return new CourseLessonsModel(lessons);
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

}




package free.edu.demo.controller;


import free.edu.demo.entities.Course;
import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Student;
import free.edu.demo.entities.Task;
import free.edu.demo.model.*;
import free.edu.demo.services.CourseService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseActionController {


    private final CourseService courseService;

    public CourseActionController(CourseService courseService) {

        this.courseService = courseService;
    }

    @CrossOrigin
    @GetMapping(value = "/lessons")
    public ListOfLessonsModel getLessons(@RequestBody Long courseId) {
        Course course = courseService.getCourse(courseId);
        List<Lesson> lessons = courseService.getAllLessonByCourse(course);
        return new ListOfLessonsModel(lessons);
    }


    @CrossOrigin
    @PostMapping(value = "/createLesson")
    public void addCourseByTeacher(@RequestBody LessonModel receivedLesson) {
        Course course = courseService.getCourse(receivedLesson.getCourseId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(receivedLesson.getDate(), formatter);
        Lesson lesson = new Lesson(receivedLesson.getDescription(), date, course);
        courseService.addLesson(lesson);
    }

    @CrossOrigin
    @GetMapping(value = "/tasks")
    public ListOfTasksModel getTasks(@RequestBody Long courseId) {
        Course course = courseService.getCourse(courseId);
        List<Task> tasks = courseService.getTasksByCourse(course);
        return new ListOfTasksModel(tasks);
    }

    @CrossOrigin
    @GetMapping(value = "/students")
    public ListOfStudentsModel getStudents(@RequestParam Long id) {
        List<Student> students = courseService.getStudentsByCourse(id);
        return new ListOfStudentsModel(students);

    }


}




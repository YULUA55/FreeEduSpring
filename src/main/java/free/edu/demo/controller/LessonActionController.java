package free.edu.demo.controller;


import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Task;
import free.edu.demo.model.*;

import free.edu.demo.services.LessonService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonActionController {


    private final LessonService lessonService;

    public LessonActionController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @CrossOrigin
    @GetMapping(value = "/tasks")
    public ListOfTasksModel getLessons(@RequestBody Long lessonId) {
        Lesson lesson = lessonService.getLesson(lessonId);
        List<Task> tasks = lessonService.getAllTasksByLesson(lesson);
        return new ListOfTasksModel(tasks);
    }


    @CrossOrigin
    @PostMapping(value = "/createTask")
    public void createTaskByLesson(@RequestBody TaskModel receivedTask) {
        Lesson lesson = lessonService.getLesson(receivedTask.getLessonId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime deadline = LocalDateTime.parse(receivedTask.getDeadline(), formatter);
        Task task = new Task(receivedTask.getDescription(), deadline, lesson);
        lessonService.addTask(task);
    }

}




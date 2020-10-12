package free.edu.demo.services;


import free.edu.demo.entities.Lesson;
import free.edu.demo.entities.Task;
import free.edu.demo.repository.LessonRepository;
import free.edu.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final TaskRepository taskRepository;

    public LessonService(LessonRepository lessonRepository, TaskRepository taskRepository) {
        this.lessonRepository = lessonRepository;
        this.taskRepository = taskRepository;
    }

    public Lesson getLesson(Long id) {

        return lessonRepository.findByLessonId(id);
    }

    public List<Task> getAllTasksByLesson(Lesson lesson) {

        return taskRepository.findAllByLesson(lesson);
    }


    public void addTask(Task task) {

        taskRepository.save(task);
    }

}

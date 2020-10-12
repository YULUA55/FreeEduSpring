package free.edu.demo.model;

import java.io.Serializable;

public class TaskModel implements Serializable {

    String description;
    String deadline;
    Long lessonId;

    public TaskModel(){}

    public TaskModel(String description, String deadline, Long lessonId) {
        this.description = description;
        this.deadline = deadline;
        this.lessonId = lessonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}

package free.edu.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LESSON_ID")
    @JsonIgnore
    private Lesson lesson;

    public Task(){

    }

    public long getTaskId() {
        return taskId;
    }

    public Task(String description, LocalDateTime deadline, Lesson lesson) {
        this.description = description;
        this.deadline = deadline;
        this.lesson = lesson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lesson guest = (Lesson) obj;
        return (((description.equals(guest.getDescription())) && deadline.equals(guest.getDate()))
        );
    }
}

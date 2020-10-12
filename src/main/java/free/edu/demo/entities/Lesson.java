package free.edu.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="LESSON")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lessonId;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="DATE")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COURSE_ID")
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Lesson() {
    };

    public Lesson(String description, LocalDateTime date, Course course) {
        this.description = description;
        this.date = date;
        this.course = course;
    }

    public long getLessonId() {
        return lessonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setData(LocalDateTime date) {
        this.date = date;
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
        return (((description.equals(guest.getDescription())) && date.equals(guest.getDate()))
        );
    }
}

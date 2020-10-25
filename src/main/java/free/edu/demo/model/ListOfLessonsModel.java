package free.edu.demo.model;

import free.edu.demo.entities.Lesson;

import java.io.Serializable;
import java.util.List;

public class ListOfLessonsModel implements Serializable {

    List<Lesson> lessons;

    public ListOfLessonsModel(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

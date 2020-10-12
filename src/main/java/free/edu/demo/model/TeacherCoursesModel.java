package free.edu.demo.model;

import free.edu.demo.entities.Course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeacherCoursesModel implements Serializable {

    List<Course> courses;

    public TeacherCoursesModel(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}

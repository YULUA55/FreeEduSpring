package free.edu.demo.model;

import free.edu.demo.entities.Course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListOfCoursesModel implements Serializable {

    List<Course> courses;

    public ListOfCoursesModel(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}

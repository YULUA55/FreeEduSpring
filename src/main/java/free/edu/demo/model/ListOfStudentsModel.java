package free.edu.demo.model;

import free.edu.demo.entities.Student;

import java.io.Serializable;
import java.util.List;

public class ListOfStudentsModel implements Serializable {

    private List<Student> students;

    public ListOfStudentsModel(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

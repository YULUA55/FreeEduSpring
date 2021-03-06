package free.edu.demo.model;

import free.edu.demo.entities.Task;

import java.io.Serializable;
import java.util.List;

public class ListOfTasksModel implements Serializable {

    private List<Task> tasks;

    public ListOfTasksModel(List<Task> tasks) {

        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

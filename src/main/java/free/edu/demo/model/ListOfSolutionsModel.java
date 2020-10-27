package free.edu.demo.model;

import free.edu.demo.entities.Solution;

import java.io.Serializable;
import java.util.List;

public class ListOfSolutionsModel implements Serializable {

    private List<Solution> solutions;

    public ListOfSolutionsModel() {
    }

    public ListOfSolutionsModel(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}

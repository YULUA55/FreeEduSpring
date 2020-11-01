package free.edu.demo.model;

import java.io.Serializable;

public class MarkModel implements Serializable {

    Long solutionId;
    int mark;

    public MarkModel(){};

    public MarkModel(Long solutionId, int mark) {
        this.solutionId = solutionId;
        this.mark = mark;
    }

    public Long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}

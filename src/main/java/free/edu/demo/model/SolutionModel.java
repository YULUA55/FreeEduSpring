package free.edu.demo.model;

import java.io.Serializable;

public class SolutionModel implements Serializable {

    private String answer;
    private Long studentId;
    private Long taskId;

    public SolutionModel(){}

    public SolutionModel(String answer, Long studentId, Long taskId) {
        this.answer = answer;
        this.studentId = studentId;
        this.taskId = taskId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}

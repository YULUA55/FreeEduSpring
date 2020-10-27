package free.edu.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "SOLUTION")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long solutionId;
    @Column(name = "ANSWER")
    private String answer;
    @Column(name = "MARK")
    private int mark;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    @JsonIgnore
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    @JsonIgnore
    private Task task;

    public Solution() {

    }

    public Solution(String answer, Student student, Task task) {
        this.answer = answer;
        this.student = student;
        this.task = task;
    }

    public Long getSolutionId() {
        return solutionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

package free.edu.demo.repository;

import free.edu.demo.entities.Solution;
import free.edu.demo.entities.Student;
import free.edu.demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {

    Solution findBySolutionId(Long solutionId);

    List<Solution> findAllByStudent(Student student);

    List<Solution> findAllByTask(Task task);


}

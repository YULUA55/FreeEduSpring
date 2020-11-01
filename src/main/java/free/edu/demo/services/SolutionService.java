package free.edu.demo.services;

import free.edu.demo.entities.Solution;
import free.edu.demo.repository.SolutionRepository;
import org.springframework.stereotype.Service;

@Service
public class SolutionService {

    private final SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    public Solution getSolutionById(Long solutionId) {
        return solutionRepository.findBySolutionId(solutionId);
    }

    public void updateMark(Long solutionId, int mark) {
        Solution solution = getSolutionById(solutionId);
        solution.setMark(mark);
        solutionRepository.save(solution);
    }
}

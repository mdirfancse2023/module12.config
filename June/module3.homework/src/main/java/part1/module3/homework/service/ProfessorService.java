package part1.module3.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import part1.module3.homework.entity.Professor;
import part1.module3.homework.repository.ProfessorRepo;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepo professorRepo;
    public void addProfessor(Professor professor) {
        professorRepo.save(professor);
    }

    public Professor getProfessor(Long id){
        return professorRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
    }
}

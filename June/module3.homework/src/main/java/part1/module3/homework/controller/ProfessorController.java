package part1.module3.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import part1.module3.homework.entity.Professor;
import part1.module3.homework.service.ProfessorService;

@RestController
@RequestMapping("/api/v1/professor")
@AllArgsConstructor
public class ProfessorController {
    private ProfessorService professorService;

    @PostMapping("/createProfessor")
    public void createProfessor(@RequestBody Professor professor) {
        professorService.addProfessor(professor);
    }
}

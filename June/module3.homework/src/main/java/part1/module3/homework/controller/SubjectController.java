package part1.module3.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import part1.module3.homework.entity.Subject;
import part1.module3.homework.service.SubjectService;

@RestController
@RequestMapping("/api/v1/subject")
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }
}

package part1.module3.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import part1.module3.homework.entity.Student;
import part1.module3.homework.entity.Subject;
import part1.module3.homework.repository.SubjectRepo;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectRepo subjectRepo;
    public void addSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    public Subject getSubject(Long subjectId) {
        return subjectRepo.findById(subjectId).orElseThrow(()->new RuntimeException("Subject Not Found"));
    }

    public void addStudent(Subject subject) {
        subjectRepo.save(subject);
    }
}

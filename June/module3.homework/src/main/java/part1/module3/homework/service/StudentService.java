package part1.module3.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import part1.module3.homework.entity.Professor;
import part1.module3.homework.entity.Student;
import part1.module3.homework.entity.Subject;
import part1.module3.homework.repository.StudentRepo;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepo studentRepo;
    private ProfessorService professorService;
    private SubjectService subjectService;
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStudent(Long id){
        return studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
    }

    public void assignProfessor(Long professorId, Long studentId) {
        Student student = getStudent(studentId);
        Professor professor = professorService.getProfessor(professorId);
        student.getProfessors().add(professor);
        studentRepo.save(student);
    }

    public void assignSubject(Long subjectId, Long studentId) {
        Student student = getStudent(studentId);
        Subject subject = subjectService.getSubject(subjectId);
        subject.getStudents().add(student);
        subjectService.addStudent(subject);
    }
}

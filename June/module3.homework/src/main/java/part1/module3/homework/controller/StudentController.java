package part1.module3.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import part1.module3.homework.entity.Student;
import part1.module3.homework.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/getStudent/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/{studentId}/assignProfessor/{professorId}")
    public void assignProfessor(@PathVariable Long professorId, @PathVariable Long studentId){
        studentService.assignProfessor(professorId, studentId);
    }

    @PostMapping("/{studentId}/assignSubject/{subjectId}")
    public void assignSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        studentService.assignSubject(subjectId, studentId);
    }

}

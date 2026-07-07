package june.module2.homework.controller;

import jakarta.validation.Valid;
import june.module2.homework.entity.DepartmentEntity;
import june.module2.homework.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/departments")
    public List<DepartmentEntity> getDepartment(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Optional<DepartmentEntity> getDepartments(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public DepartmentEntity createDepartment(@Valid @RequestBody DepartmentEntity entity){
        return departmentService.createDepartment(entity);
    }

    @PutMapping("/departments/{id}")
    public DepartmentEntity updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentEntity entity){
        return departmentService.updateDepartmentById(id, entity);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return "Department deleted";
    }
}

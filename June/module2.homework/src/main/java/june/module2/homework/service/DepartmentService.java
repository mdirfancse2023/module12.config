package june.module2.homework.service;

import june.module2.homework.anotation.Password;
import june.module2.homework.anotation.Prime;
import june.module2.homework.entity.DepartmentEntity;
import june.module2.homework.entity.EmployeeEntity;
import june.module2.homework.repository.DepartmentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public DepartmentEntity createDepartment(DepartmentEntity entity) {
        return departmentRepository.save(entity);
    }

    public DepartmentEntity updateDepartmentById(Long id, DepartmentEntity entity) {
        //We need to write logic
        return departmentRepository.save(entity);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
    //@Prime
    //Integer primeNumber;

    //@Password
    //String password;
}

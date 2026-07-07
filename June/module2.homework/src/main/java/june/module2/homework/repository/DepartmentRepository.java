package june.module2.homework.repository;

import june.module2.homework.entity.DepartmentEntity;
import june.module2.homework.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}

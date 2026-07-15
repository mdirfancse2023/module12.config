package june.two.databases.postgres.repository;

import june.two.databases.postgres.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
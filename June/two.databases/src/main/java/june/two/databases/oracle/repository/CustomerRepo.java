package june.two.databases.oracle.repository;

import june.two.databases.oracle.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}

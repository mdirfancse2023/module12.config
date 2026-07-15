package june.two.databases.controller;

import june.two.databases.oracle.entity.Customer;
import june.two.databases.oracle.repository.CustomerRepo;
import june.two.databases.postgres.entity.Employee;
import june.two.databases.postgres.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final EmployeeRepo employeeRepository;
    private final CustomerRepo customerRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}

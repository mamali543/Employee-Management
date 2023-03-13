package com.redacode.redacode.repo;

import com.redacode.redacode.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //this is called query method, spring is gping to crate  a query that understand the convention of the name and execute it
    void deleteEmployeeById(long id);

    Optional<Employee> findEmployeeById(long id);
}

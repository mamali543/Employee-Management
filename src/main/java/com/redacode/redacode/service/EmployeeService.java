package com.redacode.redacode.service;

import com.redacode.redacode.exception.userNotFoundException;
import com.redacode.redacode.model.Employee;
import com.redacode.redacode.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    //we injected this repository in this class so we can work with it in this class
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(String.valueOf(UUID.randomUUID()));
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployee(long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new userNotFoundException("User by id:  " + id +" was not found!"));
    }
}

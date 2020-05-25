package com.example.jpaz.service;

import com.example.jpaz.dao.EmployeeRepo;
import com.example.jpaz.entity.Employee;
import com.example.jpaz.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) throws EmployeeNotFoundException {
        Optional<Employee> employee=employeeRepo.findById(id);

        if(!employee.isPresent())
            throw new EmployeeNotFoundException("employee not found");
        return employee;
    }
    public Employee save(Employee emp){
        return employeeRepo.save(emp);
    }
    public void deleteById(int id){
        employeeRepo.deleteById(id);
    }


    public Employee updateEmployeeById(int id,String newName) throws EmployeeNotFoundException {

        if(!employeeRepo.findById(id).isPresent()) {
            throw new EmployeeNotFoundException("employee not found");
        }
        Employee employee=employeeRepo.getOne(id);
        employee.setEmpName(newName);
        return employeeRepo.save(employee);

    }
}

package com.example.jpaz.controller;

import com.example.jpaz.entity.Employee;
import com.example.jpaz.exception.EmployeeNotFoundException;
import com.example.jpaz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String helloController(){
        return "Hey the Application is running on port 8050 !";
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.findAllEmployee());
    }
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById( @PathVariable int id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());

        }
    }
    @PostMapping("/employee/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp){
        return ResponseEntity.ok().body(employeeService.save(emp));
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeByID(@PathVariable int id){
        employeeService.deleteById(id);
        return "Employee deleted!";
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployeeById(@PathVariable int id,@RequestBody String newName) {
        try {
            return employeeService.updateEmployeeById(id, newName);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}
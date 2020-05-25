package com.example.jpaz.dao;



import com.example.jpaz.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
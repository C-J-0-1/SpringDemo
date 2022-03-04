package com.practice.companysecurity.repositories;

import com.practice.companysecurity.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
    Employee findByFirstName(String username);
}

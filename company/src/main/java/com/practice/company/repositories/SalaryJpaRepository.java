package com.practice.company.repositories;

import com.practice.company.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryJpaRepository extends JpaRepository<Salary, Integer> {
}

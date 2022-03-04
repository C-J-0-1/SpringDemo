package com.practice.companysecurity.repositories;

import com.practice.companysecurity.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryJpaRepository extends JpaRepository<Salary, Integer> {
}

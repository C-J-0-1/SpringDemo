package com.practice.company.repositories;

import com.practice.company.models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollJpaRepository extends JpaRepository<Payroll, Integer> {
}

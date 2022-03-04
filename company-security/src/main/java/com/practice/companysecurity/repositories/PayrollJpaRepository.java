package com.practice.companysecurity.repositories;

import com.practice.companysecurity.models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollJpaRepository extends JpaRepository<Payroll, Integer> {
}

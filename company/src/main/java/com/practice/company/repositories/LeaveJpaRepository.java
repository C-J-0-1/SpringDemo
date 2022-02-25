package com.practice.company.repositories;

import com.practice.company.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveJpaRepository extends JpaRepository<Leave, Integer> {
}

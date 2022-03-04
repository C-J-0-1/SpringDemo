package com.practice.companysecurity.repositories;

import com.practice.companysecurity.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveJpaRepository extends JpaRepository<Leave, Integer> {
}

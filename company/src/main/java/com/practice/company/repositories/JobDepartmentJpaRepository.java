package com.practice.company.repositories;

import com.practice.company.models.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDepartmentJpaRepository extends JpaRepository<JobDepartment, Integer> {
}

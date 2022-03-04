package com.practice.companysecurity.repositories;

import com.practice.companysecurity.models.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDepartmentJpaRepository extends JpaRepository<JobDepartment, Integer> {
}

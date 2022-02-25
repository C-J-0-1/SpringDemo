package com.practice.company.controllers;

import com.practice.company.models.JobDepartment;
import com.practice.company.repositories.JobDepartmentJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job_department")
public class JobDepartmentController {
    @Autowired
    private JobDepartmentJpaRepository jobDepartmentJpaRepository;

    @GetMapping
    public List<JobDepartment> getJobDepartmentList(){
        return jobDepartmentJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public JobDepartment getJobDepartment(@PathVariable Integer id){
        return jobDepartmentJpaRepository.getById(id);
    }

    @PostMapping
    public void createJobDepartment(@RequestBody JobDepartment jobDepartment){
        jobDepartmentJpaRepository.saveAndFlush(jobDepartment);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteJobDepartment(@PathVariable Integer id){
        jobDepartmentJpaRepository.deleteById(id);
    }

    @PutMapping
    public JobDepartment updateJobDepartment(@PathVariable Integer id, @RequestBody JobDepartment jobDepartment){
        JobDepartment currentJobDepartment = jobDepartmentJpaRepository.getById(id);
        BeanUtils.copyProperties(jobDepartment, currentJobDepartment, "job_id");
        return jobDepartmentJpaRepository.saveAndFlush(jobDepartment);
    }
}

package com.practice.company.controllers;

import com.practice.company.models.Salary;
import com.practice.company.repositories.SalaryJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryJpaRepository salaryJpaRepository;

    @GetMapping
    public List<Salary> getSalaryList(){
        return salaryJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Salary getSalary(@PathVariable Integer id){
        return salaryJpaRepository.getById(id);
    }

    @PostMapping
    public void createSalary(@RequestBody final Salary salary){
        salaryJpaRepository.saveAndFlush(salary);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteSalary(@PathVariable Integer id){
        salaryJpaRepository.deleteById(id);
    }

    @PutMapping
    public Salary updateSalary(@PathVariable Integer id, @RequestBody Salary salary){
        Salary currentSalary = salaryJpaRepository.getById(id);
        BeanUtils.copyProperties(salary, currentSalary, "salary_id");
        return salaryJpaRepository.saveAndFlush(salary);
    }
}

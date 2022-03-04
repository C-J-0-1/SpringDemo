package com.practice.companysecurity.controllers;

import com.practice.companysecurity.models.Employee;
import com.practice.companysecurity.repositories.EmployeeJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @GetMapping
    public List<Employee> getEmployeeList(){
        return employeeJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeJpaRepository.getById(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody final Employee employee){
        employeeJpaRepository.saveAndFlush(employee);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeJpaRepository.deleteById(id);
    }

    @PutMapping
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Employee currentEmployee = employeeJpaRepository.getById(id);
        BeanUtils.copyProperties(employee, currentEmployee, "employee_id");
        return employeeJpaRepository.saveAndFlush(employee);
    }

    @RequestMapping("/form")
    public String formDemo(){
        return "index";
    }
}

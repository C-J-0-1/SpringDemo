package com.practice.company.controllers;

import com.practice.company.models.Payroll;
import com.practice.company.repositories.PayrollJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollJpaRepository payrollJpaRepository;

    @GetMapping
    public List<Payroll> getPayrollList(){
        return payrollJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Payroll getPayroll(@PathVariable Integer id){
        return payrollJpaRepository.getById(id);
    }

    @PostMapping
    public void createPayroll(@RequestBody final Payroll payroll){
        payrollJpaRepository.saveAndFlush(payroll);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deletePayroll(@PathVariable Integer id){
        payrollJpaRepository.deleteById(id);
    }

    @PutMapping
    public Payroll updatePayroll(@PathVariable Integer id, @RequestBody Payroll payroll){
        Payroll currentPayroll = payrollJpaRepository.getById(id);
        BeanUtils.copyProperties(payroll, currentPayroll, "payroll_id");
        return payrollJpaRepository.saveAndFlush(payroll);
    }
}

package com.practice.company.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payroll")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payroll {
    @Id
    @Column(name = "payroll_id")
    private Integer id;

    @Column(name = "employee_id")
    private Integer empPayrollId;

    @Column(name = "job_id")
    private Integer jobPayrollId;

    @Column(name = "salary_id")
    private Integer salaryPayrollId;

    private LocalDate date;
    private String report;

    @Column(name = "total_amount")
    private int total_salary;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false, insertable = false, updatable = false)
    private JobDepartment jobDepartmentPayroll;

    @ManyToOne
    @JoinColumn(name = "salary_id", nullable = false, insertable = false, updatable = false)
    private Salary salary;

    public Payroll(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpPayrollId() {
        return empPayrollId;
    }

    public void setEmpPayrollId(Integer empPayrollId) {
        this.empPayrollId = empPayrollId;
    }

    public Integer getJobPayrollId() {
        return jobPayrollId;
    }

    public void setJobPayrollId(Integer jobPayrollId) {
        this.jobPayrollId = jobPayrollId;
    }

    public Integer getSalaryPayrollId() {
        return salaryPayrollId;
    }

    public void setSalaryPayrollId(Integer salaryPayrollId) {
        this.salaryPayrollId = salaryPayrollId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(int total_salary) {
        this.total_salary = total_salary;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public JobDepartment getJobDepartmentPayroll() {
        return jobDepartmentPayroll;
    }

    public void setJobDepartmentPayroll(JobDepartment jobDepartmentPayroll) {
        this.jobDepartmentPayroll = jobDepartmentPayroll;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}

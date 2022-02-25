package com.practice.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobDepartment {
    @Id
    @Column(name = "job_id")
    private Integer id;

    @Column(name = "job_department")
    private String jobDepartment;

    @Column(name = "name")
    private String jobName;

    @Column(name = "description")
    private String jobDescription;

    @Column(name = "salary_range")
    private String salaryRange;

    @OneToMany(mappedBy = "jobDepartmentSalary")
    @JsonIgnore
    private List<Salary> salaries;

    @OneToMany(mappedBy = "jobDepartmentPayroll")
    @JsonIgnore
    private List<Payroll> payrolls;

    public JobDepartment(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobDepartment() {
        return jobDepartment;
    }

    public void setJobDepartment(String jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }
}

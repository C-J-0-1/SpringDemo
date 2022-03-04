package com.practice.companysecurity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salary")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
public class Salary {
    @Id
    @Column(name = "salary_id")
    private Integer id;

    @Column(name = "job_id")
    private Integer jobId;

    private String amount;

    @Column(name = "anual")
    private String annual;
    private String bonus;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false, insertable = false, updatable = false)
    private JobDepartment jobDepartmentSalary;

    @OneToMany(mappedBy = "salary")
    @JsonIgnore
    private List<Payroll> payrolls;

    /*public Salary(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public JobDepartment getJobDepartmentSalary() {
        return jobDepartmentSalary;
    }

    public void setJobDepartmentSalary(JobDepartment jobDepartmentSalary) {
        this.jobDepartmentSalary = jobDepartmentSalary;
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }*/
}

package com.example.jpaz.entity;


import javax.persistence.*;



@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="emp_id",length=3,nullable=false,unique=true)
    private Integer empId;
    @Column(name="emp_name",nullable=false,unique=true)
    private String empName;
    @Column(name = "emp_email",nullable = false,unique=true)
    private String empEmail;
    @Column(name = "emp_org")
    private String empOrg;
    @Digits
    @Size(min=10, max=10, message = "Mobile number must be a 10-digit number")
    @Column(name="emp_phone")
    private long empPhone;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail, String empOrg, long empPhone) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empOrg = empOrg;
        this.empPhone = empPhone;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpOrg() {
        return empOrg;
    }

    public void setEmpOrg(String empOrg) {
        this.empOrg = empOrg;
    }

    public long getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(long empPhone) {
        this.empPhone = empPhone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empOrg='" + empOrg + '\'' +
                ", empPhone=" + empPhone +
                '}';
    }
}
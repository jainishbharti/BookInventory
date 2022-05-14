package com.spring.bookinventory.entity;


import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeeId;
    private String employeeName;
    private String designation;
    private String email;
    private Double salary;

    public Employee(){
    }

    public Employee(String employeeName, String designation, String email, Double salary) {
        this.employeeName = employeeName;
        this.designation = designation;
        this.email = email;
        this.salary = salary;
    }

    public Employee(Integer employeeId, String employeeName, String designation, String email, Double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.email = email;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}

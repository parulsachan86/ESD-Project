package com.example.esd_placement.Bean;


import jakarta.persistence.*;
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(Integer emp_id, String first_name, String last_name, String password, String email, Department department) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.department = department;
    }
    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}

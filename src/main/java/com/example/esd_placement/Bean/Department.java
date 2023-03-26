package com.example.esd_placement.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Department {
    @Id
    @Column(name ="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="department",fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Employee> employee;

    @Column(nullable = false)
    private int capacity;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Employee> getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(List<Employee> employee) {
//        this.employee = employee;
//    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Department(int departmentID, String name, List<Employee> employee, int capacity) {
        this.departmentID = departmentID;
        this.name = name;
        //this.employee = employee;
        this.capacity = capacity;
    }
    public Department(){}

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                //", employee=" + employee +
                ", capacity=" + capacity +
                '}';
    }
}

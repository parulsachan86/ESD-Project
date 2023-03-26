package com.example.esd_placement.DAO;

import com.example.esd_placement.Bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee login(Employee employee);
    boolean addEmployee(Employee empobj);
}

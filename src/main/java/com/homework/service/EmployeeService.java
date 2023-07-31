package com.homework.service;

import com.homework.model.Employee;


import java.util.*;


public interface EmployeeService {
    void createEmployee(Employee emp);
    void createMultipleEmployees(List<Employee> empList);
    Employee getEmployeeById(Long id) throws Exception;
    void updateEmployeeDetailsById(Employee emp);
    String deleteEmployeeById(Long id);
    List<Employee> getEmployeeListGreaterThan(int sal);
}
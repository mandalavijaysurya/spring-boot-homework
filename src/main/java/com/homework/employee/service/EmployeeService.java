package com.homework.employee.service;

import com.homework.employee.model.Employee;


import java.util.*;


public interface EmployeeService {
    Employee createEmployee(Employee emp);
    void createMultipleEmployees(List<Employee> empList);
    Employee getEmployeeById(Long id) ;
    void updateEmployeeDetailsById(Employee emp);
    String deleteEmployeeById(Long id);
    List<Employee> getEmployeeListGreaterThan(int sal);
}

package com.homework.service.impl;

import com.homework.model.Employee;
import com.homework.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee>  employeeList = new ArrayList<>();
    @Override
    public void createEmployee(Employee emp) {
        employeeList.add(emp);
    }

    @Override
    public void createMultipleEmployees(List<Employee> empList){
       employeeList.addAll(empList);
    }
    @Override
    public Employee getEmployeeById(Long id) throws Exception {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseThrow(() -> new Exception(id+" is invalid. Couldn't able to find employee with id as "+id));
    }

    @Override
    public void updateEmployeeDetailsById(Employee uEmp) {
        employeeList.forEach(emp -> {
            if(emp.getId().equals(uEmp.getId())){
                emp.setId(uEmp.getId());
                emp.setSalary(uEmp.getSalary());
                emp.setFirstName(uEmp.getFirstName());
                emp.setLastName(uEmp.getLastName());
            }
        });
    }

    @Override
    public String deleteEmployeeById(Long id) {
        employeeList = employeeList.stream().filter(emp -> !emp.getId().equals(id)).toList();
        return "Employee was removed from list";
    }

    @Override
    public List<Employee> getEmployeeListGreaterThan(int sal) {
        return employeeList.stream().filter(emp -> emp.getSalary() > sal).toList();
    }
}

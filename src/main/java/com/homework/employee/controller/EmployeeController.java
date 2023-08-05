package com.homework.employee.controller;

import com.homework.employee.model.Employee;
import com.homework.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/add-employee")
    public String addEmployee(@RequestBody Employee emp){
        service.createEmployee(emp);
        return "Employee has been added";
    }

    @PostMapping("/multiple-employees")
    public String addMultipleUsers(@RequestBody List<Employee> empList){
        service.createMultipleEmployees(empList);
        return "Employees have been added";
    }

    @GetMapping("/employee-salary-greater-than")
    public List<Employee> getEmployeeListGreaterThanInp(@RequestParam int sal){
        return service.getEmployeeListGreaterThan(sal);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee searchEmployee(@PathVariable Long id) throws Exception {
        return service.getEmployeeById(id);
    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee emp){
        service.updateEmployeeDetailsById(emp);
        return emp.getFirstName()+" "+emp.getLastName()+" "+" details has been updated";
    }
    @DeleteMapping("/employee/{id}")
    public String deleteUser(@PathVariable Long id){
        return service.deleteEmployeeById(id);
    }


}

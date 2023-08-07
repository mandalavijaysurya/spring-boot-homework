package com.homework.employee.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.employee.entity.EmployeeEntity;
import com.homework.employee.exception.EmployeeException;
import com.homework.employee.model.Employee;
import com.homework.employee.repository.EmployeeRepository;
import com.homework.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity =
                EmployeeEntity.builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .salary(employee.getSalary())
                        .build();
        employeeEntity = employeeRepository.save(employeeEntity);
        employee.setId(employeeEntity.getEmployeeId());
        return employee;
    }

    @Override
    public void createMultipleEmployees(List<Employee> employeeList){
        employeeList.forEach(n -> {
                EmployeeEntity employeeEntity = EmployeeEntity.builder()
                            .firstName(n.getFirstName())
                            .lastName(n.getLastName())
                            .salary(n.getSalary())
                            .build();
                employeeEntity = employeeRepository.save(employeeEntity);
                }
        );
    }
    @Override
    public Employee getEmployeeById(Long id) throws EmployeeException {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException(id+" was not found"));
        Employee employee = objectMapper.convertValue(employeeEntity,Employee.class);
        employee.setId(employeeEntity.getEmployeeId());
        return employee;
    }

    @Override
    public void updateEmployeeDetailsById(Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employee.getId()).orElseThrow(() ->  new EmployeeException("Could able to find "+employee.getId()));
        employeeRepository.save(objectMapper.convertValue(employee,EmployeeEntity.class));
    }

    @Override
    public String deleteEmployeeById(Long id) {
       EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Could able to find "+ id));
       employeeRepository.delete(employeeEntity);
       return id +" has been deleted";
    }

    @Override
    public List<Employee> getEmployeeListGreaterThan(int sal) {
       List<EmployeeEntity> employeeEntityList = employeeRepository.findBySalaryGreaterThanEqual(sal);
       return employeeEntityList.stream().map(n -> {
           Employee employee = objectMapper.convertValue(n,Employee.class);
           employee.setId(n.getEmployeeId());
           return employee;
       }).toList();
    }
}

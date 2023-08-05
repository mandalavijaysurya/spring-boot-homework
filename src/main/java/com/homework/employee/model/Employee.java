package com.homework.employee.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.io.Serializable;


@Data
@Builder
public class Employee implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private int salary;
}

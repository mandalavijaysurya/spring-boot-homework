package com.homework.employee.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmployeeException extends RuntimeException{
    // What happens if we use generic way of creation of constructor here??
    private final String message;
}

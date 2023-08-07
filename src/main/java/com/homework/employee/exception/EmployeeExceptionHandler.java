package com.homework.employee.exception;

import com.homework.employee.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmployeeExceptionHandler {

    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeException employeeException){
       ErrorResponse message = new ErrorResponse(employeeException.getMessage());
       return new ResponseEntity<>(message,HttpStatusCode.valueOf(404));
    }

    public ResponseEntity<ErrorResponse> handleRestAllExceptions(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Oops! there was something issue at our side😵. Bois🤓 are looking into this");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Exception",String.valueOf(exception.getCause()));
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).headers(headers).body(errorResponse);
    }
}

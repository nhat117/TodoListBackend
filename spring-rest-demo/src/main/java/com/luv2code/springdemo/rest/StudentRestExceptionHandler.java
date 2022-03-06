package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Best Practice
@ControllerAdvice
public class StudentRestExceptionHandler {
    //Add exception handling code here
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        //Create a Student Error Response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //Jackson do for you
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Global exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMsg(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //Jackson do for you
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

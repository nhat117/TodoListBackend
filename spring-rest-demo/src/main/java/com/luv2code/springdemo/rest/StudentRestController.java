package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@Component
public class StudentRestController {

    //Define endpoint for "/students" -> return list of studnet
    private List<Student> theStudents;

    //Define @Post Costruct to load student data
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima", "Mateo"));
        theStudents.add(new Student("Vandevalt", "Caruso"));
        theStudents.add(new Student("Mary", "Valencia"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        loadData();
        return theStudents;
    }

    //Define endpoint for"/student/{student}id" -> Student information at tindex
    //Inlinevariable
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        loadData();
//        int studentId = verification(studentid);
        //Check student id again list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        //Normal case
        return theStudents.get(studentId);
    }

    //Add exception handler


//Utility function to check is number
//    public boolean isNumeric(String strNum) {
//        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
//        if (strNum == null) {
//            return false;
//        }
//        return pattern.matcher(strNum).matches();
//    }
//
//    private Integer verification(String studentid) {
//        if(!isNumeric(studentid)) {
//            throw new StudentNotFoundException("Enter value is not a number: " + studentid);
//        }
//        return Integer.parseInt(studentid);
//      }

}














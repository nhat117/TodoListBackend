package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;



@RestController
public class DelichillAPIRestController {

    @Value("${coach.name}")
    private String name;
    //Expose "/" end pont
    @GetMapping("/")
    public String databaseQuery() {
        //TODO:Implement a database query app
        //For testing
        return "Hello World , the time on server hello" +
                LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run hard 5k";
    }

    @GetMapping("/fortune")
    public String fortune(){
        return "Today is your lucky day";
    }

    @GetMapping("/company")
    public String company() {
      return name;
    }
}

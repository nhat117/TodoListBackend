package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@Component
//New object for each request
public class TennisCoach implements Coach {
//    Field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
//Constructor injection
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    public TennisCoach() {
        System.out.println("Init");
    }

//    Setter Injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Setter Injection");
//        this.fortuneService = fortuneService;
//    }
//Method Injection
//    @Autowired
//    public void doSomething(FortuneService fortuneService) {
//        System.out.println("Setter Injection");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand Volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    public void doMyStartUpStuff() throws FileNotFoundException {
        System.out.println("Start up");
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\nhat1\\Desktop\\Spring bôt\\demo\\src\\main\\java\\com\\spring\\demo\\hello.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String [] arr = everything.split(",");
            Random random = new Random();
            int randRes = random.nextInt(arr.length -1);
            System.out.println(arr[0]);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("Destroy");
    }
}

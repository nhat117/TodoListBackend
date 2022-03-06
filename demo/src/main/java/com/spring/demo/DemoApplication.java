package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
//	What are the beans
//	Dependecies of a bean
//	Where to search for beans
	public static void main(String[] args) {
//		BinarySearchImpl binarySearch = new BinarySearchImpl(BubbleSort());
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		Coach theCoach = applicationContext.getBean("tennisCoach",Coach.class);
//		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theCoach.getDailyFortune());
		//Default scope is Singleton
		Coach alphaCoach = applicationContext.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach== alphaCoach);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
	}
}

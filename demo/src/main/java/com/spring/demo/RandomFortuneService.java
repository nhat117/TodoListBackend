package com.spring.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    //Create an array of Strings
    private String[] data = {"abcd","jfkc","hog"};
    private Random random = new Random();

    @Override
    public String getFortune() {
        return data[random.nextInt(data.length)];
    }
}

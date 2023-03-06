package com.example.JavaPractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class test {
    @Value("${test}")
    private String str;


    public void s(){
        System.out.println(str);
    }

}

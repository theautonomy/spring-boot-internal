package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyFirstEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, 
      SpringApplication application) {
        System.out.println("================================================");
        System.out.println("run FirstEnvironmentPostProcessor");
        System.out.println("================================================");
    }

}

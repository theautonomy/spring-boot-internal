package com.example.demo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

// This doesn't make a difference
// ApplicationContextInitializer runs before context is ready 
// @Component
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("================================================");
        System.out.println("run FirstInitializer");
        System.out.println("================================================");
    }
} 

package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    BeanA beanAFromConfig() {
        System.out.println("================================================");
        System.out.println("run beanA @Configuration");
        System.out.println("================================================");
        return new BeanA();
    }
}

package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BeanA {

    @PostConstruct
    void postConstruct() {
        System.out.println("================================================");
        System.out.println("run postConstruct BeanA " + this.hashCode());
        System.out.println("================================================");
    }
}

package com.example.demo;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

// @Component
public class FirstApplicationEventListener implements ApplicationListener<SpringApplicationEvent> {

    @Override
    public void onApplicationEvent(SpringApplicationEvent springApplicationEvent) {
        System.out.println("================================================");
        System.out.println("run FirstApplicationEventListener");
        System.out.println(springApplicationEvent.toString());
        System.out.println("================================================");
    }
}

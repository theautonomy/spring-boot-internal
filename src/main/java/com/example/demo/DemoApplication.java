package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({FirstImportSelector.class, FirstImportBeanDefinitionRegistrar.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);

        // Why? https://github.com/spring-projects/spring-boot/issues/27945
        springApplication.addListeners(new FirstApplicationEventListener());
        springApplication.run();
    }
}

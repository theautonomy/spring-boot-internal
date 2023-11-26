package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication

// The import can be here or in Config.java
// @Import({FirstImportSelector.class, FirstDeferredImportSelector.class, FirstImportBeanDefinitionRegistrar.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);

        // Why? https://github.com/spring-projects/spring-boot/issues/27945
        springApplication.addListeners(new FirstApplicationEventListener());
        
        // Another way to add ApplicationContextInitializer
        // Or define the following in application.properties
        // context.initializer.classes=com.example.demo.FirstInitializer
        // springApplication.addInitializers(new FirstInitializer());
        springApplication.run();
    }
}

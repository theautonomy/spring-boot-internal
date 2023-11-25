package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({FirstImportSelector.class, FirstDeferredImportSelector.class, FirstImportBeanDefinitionRegistrar.class})
// @Import({FirstImportSelector.class,  FirstImportBeanDefinitionRegistrar.class})
public class Config {

    @Bean
    BeanA beanAFromConfig() {
        System.out.println("================================================");
        System.out.println("run beanA @Configuration");
        System.out.println("================================================");
        return new BeanA();
    }
}

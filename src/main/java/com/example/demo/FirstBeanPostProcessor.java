package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class FirstBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization( Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanA) {
            System.out.println("================================================");
            System.out.println("run FirstBeanPostProcessor postProcessBeforeInitialization");
            System.out.println("BeanA - FirstBeanPostProcessor postProcessBeforeInitialization");
            System.out.println("================================================");
        }
        return bean;
    }
 
    @Override
    public Object postProcessAfterInitialization( Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanA) {
            System.out.println("================================================");
            System.out.println("run FirstBeanPostProcessor postProcessAfterInitialization");
            System.out.println("BeanA - FirstBeanPostProcessor postProcessAfterInitialization");
            System.out.println("================================================");
        }
        return bean;
    }
}

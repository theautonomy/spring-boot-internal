package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class FirstBeanDefinitionRegistryPostProcessor  implements BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanDefinitionRegistry (BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("================================================");
            System.out.println("run FirstBeanDefinitionRegistryPostProcessor's postProcessBeanDefinitionRegistry"); 
            System.out.println("================================================");
        }

        @Override
        public void postProcessBeanFactory (ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("================================================");
            System.out.println("run FirstBeanDefinitionRegistryPostProcessor's postPrcessBeanFactory");
            System.out.println("================================================");
        }
    }

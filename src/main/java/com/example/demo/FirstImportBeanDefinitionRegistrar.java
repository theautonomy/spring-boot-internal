package com.example.demo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/*
 *
 * https://blog.csdn.net/qq_31086797/article/details/124488829
 *
 * https://www.jianshu.com/p/357eab9ec916 - need to try
 *
 */
// @Component
public class FirstImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("================================================");
        System.out.println("run FirstImportBeanDefinitionRegistrar");
        System.out.println("================================================");
    }
}

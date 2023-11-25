package com.example.demo;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

// This doesn't work. It needs to be imported - see Config.java
// @Component
public class FirstDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("================================================");
        System.out.println("run FirstDeferredImportSelector");
        System.out.println("================================================");
        return new String[0];
    }
}

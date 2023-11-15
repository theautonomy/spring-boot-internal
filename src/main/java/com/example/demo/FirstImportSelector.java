package com.example.demo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class FirstImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("================================================");
        System.out.println("run FirstImportSelector");
        System.out.println("================================================");
        return new String[0];
    }
}

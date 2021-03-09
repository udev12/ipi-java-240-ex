package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class SpringConfig {
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    public BeanExemple beanExemple(){
        BeanExemple be = new BeanExemple("Hello ");
        be.setNom("World");
        return be;
    }
}

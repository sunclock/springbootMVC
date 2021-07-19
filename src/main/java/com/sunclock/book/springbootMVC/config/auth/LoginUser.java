package com.sunclock.book.springbootMVC.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // set location where this annotation can be generated
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // annotaion class
    
}

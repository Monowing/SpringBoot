package com.example.demo.other.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 字段自定义注解
 * @Author clg
 * @Date 2020/9/29
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldAnnotation {

    /**
     * 字段名称
     * @return
     */
    public String name();

}
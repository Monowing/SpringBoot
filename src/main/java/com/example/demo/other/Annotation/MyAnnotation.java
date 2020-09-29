package com.example.demo.other.Annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 * @Author clg
 * @Date 2020/9/29
 * @Version
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    /**
     * 名称
     * @return
     */
    public String name();

    /**
     * 值
     * @return
     */
    public String value();


}

package com.example.demo.other.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 类自定义注解
 * @Author clg
 * @Date 2020/9/29
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME) // 注解保留多久
@Documented
public @interface ClassAnnotation {

    /**
     * 类名称
     *
     * @return
     */
    public String name();

}

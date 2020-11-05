package com.example.demo.other.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author clg
 * @Date 2020/9/29
 * @Version 1.0
 */

/**
 * @Retention
 * 三种策略：
 * CLASS：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * SOURCE：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期
 * RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在
 * 这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

    String value();

}

package com.example.demo.other.Annotation;

import com.example.demo.other.Annotation.ClassAnnotation;
import com.example.demo.other.Annotation.FieldAnnotation;

/**
 * 自定义注解测试类
 *
 * @Author clg
 * @Date 2020/9/29
 * @Version 1.0
 */

@ClassAnnotation(name = "MyAnnotationClass")
public class MyAnnotationClass {

    public String myClass;

    String thisClass;

    @FieldAnnotation(name = "myName")
    private String myName;

    @FieldAnnotation(name = "myValue")
    private Integer myValue;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Integer getMyValue() {
        return myValue;
    }

    public void setMyValue(Integer myValue) {
        this.myValue = myValue;
    }
}

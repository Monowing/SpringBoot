package com.example.demo.other.Annotation;

import java.lang.reflect.Field;

/**
 * @Author clg
 * @Date 2020/9/29
 * @Version 1.0
 */

public class MyAnnotationMain {

    public static void main(String[] args) throws Exception {

        MyAnnotationClass myAnnotationClass = new MyAnnotationClass();
        myAnnotationClass.myClass = "myClassIsMyAnnotationClass";
        myAnnotationClass.thisClass = "thisClassIsMyAnnotationClass";
        myAnnotationClass.setMyName("myNameIsMyAnnotationClass");
        myAnnotationClass.setMyValue(1);

        Class<? extends MyAnnotationClass> aClass = myAnnotationClass.getClass();

        // 获取字段
        Field thisClass = aClass.getDeclaredField("thisClass");
        if (thisClass == null) {
            System.out.println("can not find thisClass");
        } else {
            thisClass.setAccessible(true);
            Object o = thisClass.get(myAnnotationClass);
            System.out.println(o);
            thisClass.set(myAnnotationClass,"thisClassMyAnnotationClassChange");
            System.out.println(thisClass.get(myAnnotationClass));
        }


        MyAnnotation myAnnotation = aClass.getAnnotation(MyAnnotation.class);
        if (myAnnotation == null) {
            System.out.println("MyAnnotation is null");
        } else {
            System.out.println("MyAnnotation is " + myAnnotation.value());
            System.out.println("MyAnnotation is " + myAnnotation.name());
        }

        ClassAnnotation classAnnotation = aClass.getAnnotation(ClassAnnotation.class);
        if (classAnnotation == null) {
            System.out.println("ClassAnnotation is null");
        } else {
            System.out.println("ClassAnnotation name is " + classAnnotation.name());
        }

        FieldAnnotation fieldAnnotation = aClass.getAnnotation(FieldAnnotation.class);
        if (fieldAnnotation == null) {
            System.out.println("FieldAnnotation is null");
        } else {
            System.out.println("FieldAnnotation name is " + fieldAnnotation.name());
        }

        // 获取公有字段，public修饰
        Field[] fields = aClass.getFields();
        foreachFieldAnnotation(fields);
        foreachFields(fields);

        // 获取所有字段，包括私有
        Field[] declaredFields = aClass.getDeclaredFields();
        foreachFieldAnnotation(declaredFields);
        foreachFields(declaredFields);

    }

    /**
     * 寻找字段中是否存在FieldAnnotation注解
     *
     * @param fields
     */
    public static void foreachFieldAnnotation(Field[] fields) {
        if (fields == null || fields.length <= 0) {
            System.out.println("fields is null or empty");
        } else {
            System.out.println("fields length : " + fields.length);
            for (Field field : fields) {
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                if (annotation == null) {
                    System.out.println(field.getName() + " has no FieldAnnotation");
                } else {
                    System.out.println(field.getName() + " has FieldAnnotation");
                }
            }
        }
    }

    /**
     * 循环字段，查看字段属性
     *
     * @param fields
     */
    public static void foreachFields(Field[] fields) throws IllegalAccessException {
        if (fields == null || fields.length <= 0) {
            System.out.println("fields is null or empty");
        } else {
            System.out.println("fields length : " + fields.length);
            for (Field field : fields) {
                System.out.println("field name : " + field.getName());
                System.out.println("field type : " + field.getType());
                System.out.println("field toString : " + field.toString());
            }
        }

    }

}

package com.jacky.anno;

import java.lang.annotation.Annotation;

/**
 *
 * @anno02是可继承的注解，所以继承demo类，demo01类也会获取到@anno02这个注解
 *
 * @Authror jacky
 * @create 2019-10-10
 */
public class Demo01 extends Demo {
    public static void main(String[] args) {
        Class<Demo01> clazz = Demo01.class;
        Annotation[] annotations = clazz.getAnnotations();
        //打印该类上的注解
        System.out.println("Demo类上的注解：");
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
        System.out.println("@anno02上的注解信息：");
        anno02 anno02 = clazz.getAnnotation(com.jacky.anno.anno02.class);
        Annotation[] annotations2 = anno02.annotationType().getAnnotations();
        for (Annotation annotation : annotations2) {
            System.out.println(annotation.toString());
        }
        System.out.println("@anno01上的注解信息:");
        Annotation[] annotations1 = annotations2[2].annotationType().getAnnotations();
        for (Annotation annotation : annotations1) {
            System.out.println(annotation.toString());
        }


    }
}

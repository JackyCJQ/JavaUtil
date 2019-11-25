package com.jacky.anno;

import java.lang.annotation.Annotation;

/**
 * @Authror jacky
 * @create 2019-10-10
 */
@anno02(value = "demo")
public class Demo {

    public static void main(String[] args) {
        Class<Demo> clazz = Demo.class;
        Annotation[] annotations = clazz.getAnnotations();
        //打印该类上的注解
        System.out.println("Demo类上的注解：");
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
            //获取到具体的接口，才能最终获取到值
            anno02 anno02 = clazz.getAnnotation(com.jacky.anno.anno02.class);
            System.out.println("anno02注解的值：" + anno02.value());
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

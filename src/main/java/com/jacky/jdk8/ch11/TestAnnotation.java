package com.jacky.jdk8.ch11;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Authror jacky
 * @create 2019-03-18
 */
public class TestAnnotation {
    //编译时检查
    private @NotNull
    Object obj = null;


    //这里就可以应用重复注解了
    @MyAnnotation("ss")
    @MyAnnotation("xxx")
    public void show(@MyAnnotation("abc") String str) {

    }

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> aClass = TestAnnotation.class;
        Method show = aClass.getMethod("show");
        MyAnnotation[] annotations = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            System.out.println(annotation.value());
        }

    }

}

package com.jacky.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解实际上是一个接口，继承Annotaion
 *
 * @Authror jacky
 * @create 2019-10-10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface anno01 {
    String value() default "01";
}

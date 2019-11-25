package com.jacky.anno;

import java.lang.annotation.*;

/**
 * @Authror jacky
 * @create 2019-10-10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@anno01(value = "anno02")
@Inherited //可以被带有该类的子类继承这个注解
public @interface anno02 {
    String value() default "02";
}

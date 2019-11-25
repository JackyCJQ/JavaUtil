package com.jacky.anno;

import java.lang.annotation.Repeatable;

/**
 * 可重复注解
 *
 * @Authror jacky
 * @create 2019-10-10
 */

@Repeatable(Persons.class)
public @interface Person {
    String value() default "";
}

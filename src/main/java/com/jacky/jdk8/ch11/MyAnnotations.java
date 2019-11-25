package com.jacky.jdk8.ch11;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * jdk8对注解处理提供了两点改进：可重复注解及可用于类型的注解->TYPE_PARAMETER
 *
 * @Authror jacky
 * @create 2019-03-18
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}

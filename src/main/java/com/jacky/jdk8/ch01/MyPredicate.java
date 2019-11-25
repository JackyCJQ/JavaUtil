package com.jacky.jdk8.ch01;

/**
 * 定义一个规则
 *
 * @Authror jacky
 * @create 2019-03-13
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);
}

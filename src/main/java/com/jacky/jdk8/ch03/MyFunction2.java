package com.jacky.jdk8.ch03;

/**
 * @Authror jacky
 * @create 2019-03-14
 */
@FunctionalInterface
public interface MyFunction2<T, R> {
    R getValue(T t1, T t2);
}

package com.jacky.jdk8.ch03;


@FunctionalInterface
public interface MyFunction2<T, R> {
    R getValue(T t1, T t2);
}

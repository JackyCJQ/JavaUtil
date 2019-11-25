package com.jacky.jdk8.ch01;

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);
}

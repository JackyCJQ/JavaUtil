package com.jacky.singleton;

//
public class Singleton02 {
    //静态内部类
    private static class LazyHolder {
        private static final Singleton02 INSTANCE = new Singleton02();
    }

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
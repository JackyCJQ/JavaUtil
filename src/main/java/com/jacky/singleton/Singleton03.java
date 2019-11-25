package com.jacky.singleton;

public class Singleton03 {

    private static final Singleton03 _INSTANCE = new Singleton03();

    public static Singleton03 getInstance() {
        return _INSTANCE;
    }
}
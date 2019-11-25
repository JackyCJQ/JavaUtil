package com.jacky.singleton;

public class Singleton01 {
    private Singleton01() {
    }  //私有构造函数

    private volatile static Singleton01 instance = null;  //单例对象

    //静态工厂方法
    public static Singleton01 getInstance() {
        if (instance == null) {      //双重检测机制
            synchronized (Singleton01.class) {  //同步锁
                if (instance == null) {     //双重检测机制
                    instance = new Singleton01();
                }
            }
        }
        return instance;
    }
}
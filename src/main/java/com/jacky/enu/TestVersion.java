package com.jacky.enu;

/**
 * @Authror jacky
 * @create 2019-09-20
 */
public class TestVersion {
    public static void main(String[] args) {
        //返回所有的枚举类
        Version[] values = Version.values();
        for (Version value : values) {
            //对应的序列
            System.out.println("ordinal:" + value.ordinal());
            //对应的名字
            System.out.println("name:" + value.name());
        }
    }
}

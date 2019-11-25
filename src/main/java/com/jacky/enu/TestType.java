package com.jacky.enu;

/**
 * @Authror jacky
 * @create 2019-09-20
 */
public class TestType {
    public static void main(String[] args) {

        Type[] values = Type.values();
        for (Type value : values) {
            //对应的序列
            System.out.println("ordinal:" + value.ordinal());
            //对应的名字
            System.out.println("name:" + value.name());
            //自己定义的字段
            System.out.println("index:"+value.getIndex());
            //自己定义的值
            System.out.println(value.getValue());

        }

    }
}

package com.jacky.reflect;

import java.util.List;

/**
 * @auther
 */
public class Test extends TypeReference<List<String>> {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.toString());


    }
}

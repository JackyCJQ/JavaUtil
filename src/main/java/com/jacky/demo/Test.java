package com.jacky.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther
 */
public class Test {

    public Map<String, Student> data = new HashMap<>();

    public void before() {
        data.put("liuchang", new Student());
    }


    public void done(Map<String, Student> data) {
        Student liuchang = data.get("liuchang");
//        System.out.println(liuchang);
        liuchang.setName("liuchang");

    }


    public static void main(String[] args) {

        Test test = new Test();

        test.before();
        test.done(test.data);
        for (Map.Entry<String, Student> entry : test.data.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    @org.junit.Test
    public void test() {
        String data = "test2.mobike.com";
        String[] keys = data.split("\\.");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @org.junit.Test
    public void test1() {
        System.out.println(System.currentTimeMillis());
        long time = new Date().getTime();
        System.out.println(time);
    }

}

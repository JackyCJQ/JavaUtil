package com.jacky.bytes;

import java.nio.charset.Charset;

/**
 * @Authror jacky
 * @create 2019-11-09
 */
public class Test {

    public static void main(String[] args) {
        String str = "一";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        System.out.println(bytes.length);
        for (byte b : bytes) {

            System.out.println(Integer.toBinaryString(b));
        }
    }
    @org.junit.Test
    public void test(){
        String a="11111111111111111111111111100100";
        System.out.println(a.length());
    }
}

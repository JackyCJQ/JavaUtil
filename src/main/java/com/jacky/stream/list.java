package com.jacky.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther
 */
public class list {

    @Test
    public void test() {
        List<String> data = new ArrayList<String>();
        data.add("aaa");
        data.add(0, "bbb");
        System.out.println(data);
        System.out.println(data.size());
        data.add(data.size(), "cc");
        System.out.println(data);
        data.add(data.size(),"dd");
        System.out.println(data);

    }
}

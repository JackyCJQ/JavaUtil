package com.jacky.jdk8.ch06;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * sorted()自然排序(Comparable)
 * sorted（Comparator com）-定制排序(Comparator)
 */
public class TestStreamAPI03 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("------------------");
        emps.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }

        }).forEach(System.out::println);

    }
}

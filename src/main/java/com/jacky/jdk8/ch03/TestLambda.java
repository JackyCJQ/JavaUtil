package com.jacky.jdk8.ch03;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Authror jacky
 * @create 2019-03-14
 */
public class TestLambda {
    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.9),
            new Employee("李四", 38, 555.99),
            new Employee("王五", 50, 6666.99),
            new Employee("赵六", 16, 3333.99),
            new Employee("田七", 8, 555.99)
    );

    @Test
    public void test() {
        //先按照年龄，然后在按照名字进行排序
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test02() {
        //去掉空格
        String str = "\t\t\t 我在学习Java lambda表达式";
        str = strHandler(str, (x) -> {
            return x.trim();
        });
        System.out.println(str);
        //转为大写
        str = strHandler(str, x -> x.toUpperCase());
        System.out.println(str);
        //字符串截取
        str = strHandler(str, x -> x.substring(0, 4));
        System.out.println(str);
    }

    //用于处理字符串的方法
    private String strHandler(String str, MyFunction function) {
        return function.getValue(str);
    }

    //对于两个long型数据进行处理
    @Test
    public void test03() {
        op(12L, 13L, (x, y) -> {
            return x + y;
        });
        op(12L, 13L, (x, y) -> {
            return x - y;
        });
    }

    private void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

}

package com.jacky.jdk8.ch04;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * Consumer<T> : 消费型接口
 * void accept(T t);
 * Supplier<T> : 供给型接口
 * T get();
 * Function<T, R> : 函数型接口
 * R apply(T t);
 * Predicate<T> : 断言型接口
 * boolean test(T t);
 */
public class TestLambda {

    //Comsumer<T> 消费型接口：
    @Test
    public void test01() {

        happy(1000, x -> {
            System.out.println("消费了：" + x);
        });
    }

    private void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    // Supplier<T> : 供给型接口
    //产生一些整数，并放入集合中
    @Test
    public void test02() {
        List<Integer> numList = getNumList(10, () -> {
            return (int) (Math.random() * 100);
        });
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    private List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    // Function<T, R> : 函数型接口
    //需求，处理字符串
    @Test
    public void test03() {
        String str = strhandler("\t\t\tsadfasfwer", (x) -> {
            return x.trim();
        });
        System.out.println(str);
        str = strhandler(str, x -> x.substring(2, 5));
        System.out.println(str);
    }

    private String strhandler(String str, Function<String, String> function) {
        String s = function.apply(str);
        return s;
    }

    //Predicate<T> : 断言型接口
    //需求：将满足条件的字符串，放入集合中
    @Test
    public void test4() {
        List<String> data = Arrays.asList("aaa", "bbbb", "ccc");
        data=filterStr(data, x -> x.length() > 3);
        System.out.println(data);

    }

    public List<String> filterStr(List<String> data, Predicate<String> fun) {
        List<String> result = new ArrayList<>();
        for (String datum : data) {

            if (fun.test(datum)) {
                result.add(datum);
            }
        }
        return result;
    }


}

package com.jacky.jdk8.ch06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Authror jacky
 * @create 2019-03-17
 */
public class TestStreamAPI02 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
    @Test
    public void test1() {
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("--------------------------");
        //提取名字的操作
        Stream<String> stream = emps.stream().map(e -> e.getName());
        stream.forEach(System.out::println);
        System.out.println("--------------------------");
        //通过map操作 流中嵌套流
        Stream<Stream<Character>> stream1 = strings.stream().map(TestStreamAPI02::filterCharacter);
        stream1.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("--------------------------");
        //通过flatMap操作 最终得到的是一个流
        Stream<Character> stream2 = strings.stream().flatMap(TestStreamAPI02::filterCharacter);
        stream2.forEach(System.out::println);


    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}

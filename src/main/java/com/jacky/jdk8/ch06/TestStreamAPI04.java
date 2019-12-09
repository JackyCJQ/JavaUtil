package com.jacky.jdk8.ch06;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 终止操作
 */
public class TestStreamAPI04 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    /*
        allMatch——检查是否匹配所有元素
        anyMatch——检查是否至少匹配一个元素
        noneMatch——检查是否没有匹配的元素
        findFirst——返回第一个元素
        findAny——返回当前流中的任意元素
        count——返回流中元素的总个数
        max——返回流中最大值
        min——返回流中最小值
         */
    @Test
    public void test() {
        boolean match = emps.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(match);
        System.out.println("--------------------------");
        boolean match1 = emps.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(match1);
        System.out.println("--------------------------");
        boolean match2 = emps.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(match2);
        System.out.println("--------------------------");
        Optional<Employee> op = emps.stream().sorted((e1, e2) -> {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }).findFirst();
        System.out.println(op.get());
        System.out.println("--------------------------");
        Optional<Employee> any = emps.stream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(any.get());
    }

    @Test
    public void test1() {
        long count = emps.stream().count();
        System.out.println(count);
        System.out.println("-------------------");
        Optional<Employee> max = emps.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        //判断是否存在：max.isPresent()
        System.out.println(max.get());
        System.out.println("-------------------");
        Optional<Double> min = emps.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());
    }
}

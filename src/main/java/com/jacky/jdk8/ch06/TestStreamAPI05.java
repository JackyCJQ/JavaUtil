package com.jacky.jdk8.ch06;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Authror jacky
 * @create 2019-03-17
 */
public class TestStreamAPI05 {
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
    归约
    reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
    */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //0作为起始值 list中的值为y
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("----------------");
        Optional<Double> salary = emps.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(salary.get());
    }

    /*
      收集
       collect-将流转为其他的形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test2() {
        List<String> list = emps.stream().map(e -> e.getName()).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("--------------------");
        Set<String> set = emps.stream().map(e -> e.getName()).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("--------------------");
        HashSet<String> hashSet = emps.stream().map(e -> e.getName()).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test3() {
        //总数
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);
        System.out.println("--------------");
        //平均值
        Double salary = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(salary);
        //总和
        Double sum = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        //最大值
        Optional<Employee> max = emps.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());
    }

    /*
      分组
     */
    @Test
    public void test4() {
        Map<Employee.Status, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        collect.entrySet().forEach(System.out::println);
    }

    /*
    多级分组
     */
    @Test
    public void test5() {
        Map<Employee.Status, Map<String, List<Employee>>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus,
                Collectors.groupingBy(e -> {
                    if (e.getAge() < 30) {
                        return "青年";
                    } else {
                        return "中年";
                    }
                })));
        System.out.println(collect);
    }
    /*
    分区
     */
    @Test
    public void test6(){
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(map);
        System.out.println("----------------");
        DoubleSummaryStatistics collect = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getSum());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMax());
    }
    @Test
    public void test7(){
        String s = emps.stream().map(Employee::getName).collect(Collectors.joining(",","==","=="));
        System.out.println(s);
    }

}

package com.jacky.jdk8.ch08;

import com.jacky.ch06.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional<T>类(java.util.Optional)是一个容器类，代表一个值存在或不存在，原来用null表示一个值不存在
 * ，现在Optional可以更好的表达这个概念。并且可以避免空指针异常。
 */
public class TestOptional {
    /*
     * 一、Optional 容器类：用于尽量避免空指针异常
     * 	Optional.of(T t) : 创建一个 Optional 实例
     * 	Optional.empty() : 创建一个空的 Optional 实例
     * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
     * 	isPresent() : 判断是否包含值
     * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
     * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
     * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
     * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
     */
    @Test
    public void test() {
        //创建一个对象
        Optional<Employee> op = Optional.of(new Employee());
        System.out.println(op.get());
        //已最快的速度 发现空指针异常所在的位置
        Optional<Employee> op1 = Optional.of(null);
        System.out.println(op1.get());
    }

    @Test
    public void test2() {
        //构建一个空的对象
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test

    public void test3() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());
        Optional<Employee> op1 = Optional.ofNullable(null);
        System.out.println(op1.get());
    }
    @Test
    public void test4() {
        //如果不为空则返回，否则不做任何操作
        Optional<Employee> op = Optional.ofNullable(new Employee());
        if (op.isPresent())
            System.out.println(op.get());
        Optional<Employee> op1 = Optional.ofNullable(null);
        if (op1.isPresent())
            System.out.println(op1.get());
        Employee employee = op.orElse(new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY));
        System.out.println(employee);
        //通过方法去调用
        Employee employee1 = op.orElseGet(() -> new Employee());
    }
    @Test
    public void test5(){
        Optional<Employee> op = Optional.ofNullable(new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY));
        Optional<String> optional = op.map(e -> e.getName());
        System.out.println(optional.get());
        System.out.println("----------------");
        Optional<Employee> op1 = Optional.ofNullable(null);
        Optional<String> optional1 = op1.map(e -> e.getName());
        System.out.println(optional1.get());
    }
    @Test
    public void test6(){
        Optional<Employee> op2 = Optional.ofNullable(new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY));
        Optional<String> s = op2.flatMap(e -> Optional.of(e.getName()));
        System.out.println(s.get());
    }


}

package com.jacky.jdk8.ch01;

import org.junit.Test;

import java.util.*;

/**
 * @auther
 */
public class TestLambda {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(3);
        ts.add(2);
        System.out.println(ts);
    }

    //Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(3);
        ts.add(2);
        System.out.println(ts);
    }

    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.9),
            new Employee("李四", 38, 555.99),
            new Employee("王五", 50, 6666.99),
            new Employee("赵六", 16, 3333.99),
            new Employee("田七", 8, 555.99)
    );


    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(this.employees);
        System.out.println("第一次过滤");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("第二次过滤");
        List<Employee> employees1 = filterEmployees2(employees);
        for (Employee employee : employees1) {
            System.out.println(employee);
        }


    }

    //获取当前公司中员工年龄大于35的员工信息
    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= 35) {
                datas.add(employee);
            }
        }
        return datas;
    }

    //获取员工工资大于5000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= 5000) {
                datas.add(employee);
            }
        }
        return datas;
    }

    //优化方式一,策略模式
    @Test
    public void test4() {
        List<Employee> employees = filterEmployee(this.employees, new FilterEmployeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("-------------------");
        List<Employee> employees1 = filterEmployee(this.employees, new FilterEmployeeBySalary());
        for (Employee employee : employees1) {
            System.out.println(employee);
        }
    }


    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                datas.add(employee);
            }
        }
        return datas;
    }

    //优化方式二 匿名内部类
    public void test5() {
        List<Employee> employees = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //优化方式三 lambada表达式
    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(this.employees, e -> e.getSalary() <= 5000);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    //优化方式四， stream API
    @Test
    public void test7(){
        employees.stream().filter(e->e.getSalary()<=5000).forEach(System.out::println);
    }
}

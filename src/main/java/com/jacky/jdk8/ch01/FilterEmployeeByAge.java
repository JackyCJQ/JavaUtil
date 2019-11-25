package com.jacky.jdk8.ch01;

/**
 * @Authror jacky
 * @create 2019-03-13
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}

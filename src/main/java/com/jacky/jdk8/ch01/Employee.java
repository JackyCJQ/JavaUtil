package com.jacky.jdk8.ch01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
}

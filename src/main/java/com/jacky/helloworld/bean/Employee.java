package com.jacky.helloworld.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Employee {

    private Integer id;

    private String lastName;

    private String email;

    private String gender;

    private Short age;
}

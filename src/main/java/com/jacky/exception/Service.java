package com.jacky.exception;

/**
 * @Authror jacky
 * @create 2019-11-09
 */
public class Service {

    public String getName(String name) {
        if (name.equalsIgnoreCase("jacky")) {
            throw new RuntimeException("error");
        }
        return name;
    }

}

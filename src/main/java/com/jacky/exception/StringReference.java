package com.jacky.exception;

/**
 * @Authror jacky
 * @create 2019-11-10
 */
public class StringReference extends TypeReference<String> {

    public StringReference() {
        System.out.println(this.getClass().getSimpleName());
    }


}

package com.jacky.proxy;

/**
 * @Authror jacky
 * @create 2019-04-25
 */
public class Test {
    public static void main(String[] args) {
        UserService userService = new ServiceProxy().newInstance(UserService.class);
        userService.toString();
        userService.getUser();
    }
}

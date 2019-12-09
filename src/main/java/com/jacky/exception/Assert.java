package com.jacky.exception;

import java.util.Objects;

/**
 * 断言类
 *
 * @auther
 */
public class Assert {

    public static void notNull(String data, int code, String message) {
        if (Objects.isNull(data) || data.trim().length() == 0) {
            throw new OpsException(code, message);
        }
    }
}

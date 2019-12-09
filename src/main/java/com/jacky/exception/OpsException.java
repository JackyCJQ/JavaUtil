package com.jacky.exception;

/**
 * @auther
 */
public class OpsException extends RuntimeException {

    private int code;

    public OpsException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

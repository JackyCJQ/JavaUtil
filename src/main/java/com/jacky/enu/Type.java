package com.jacky.enu;

/**
 * 携带参数的枚举类
 *
 * @Authror jacky
 * @create 2019-09-20
 */
public enum Type {
    APP(1, "mobile"),
    PRO(2, "program");

    private Integer index;
    private String value;

    Type(Integer index, String name) {
        this.value = name;
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

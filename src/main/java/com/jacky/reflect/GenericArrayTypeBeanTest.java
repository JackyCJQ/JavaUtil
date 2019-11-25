package com.jacky.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * @auther
 */
public class GenericArrayTypeBeanTest<T> {
    //泛型数组类型
    private T[] value;
    private List<String>[] list;
    //不是泛型数组类型
    private List<String> singleList;
    private T singleValue;

    public static void main(String[] args) {
        Field[] fields = GenericArrayTypeBeanTest.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println();
            System.out.println("Field:" + field.getName() + ";instance of GenericArrayType:" + (field.getGenericType() instanceof GenericArrayType));
            if ((field.getGenericType() instanceof GenericArrayType)) {
                System.out.println("Field" + field.getName() + "; getGenericComponentType():" + ((GenericArrayType) field.getGenericType()).getGenericComponentType());
            }
        }
    }

}

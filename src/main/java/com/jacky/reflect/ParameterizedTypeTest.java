package com.jacky.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @auther
 */
public class ParameterizedTypeTest {
    //是parameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private List<String> list;
    private Class<?> clz;
    //不是parameterizedType
    private Integer i;
    private String str;
    private Enty<String> mem;


    private static void printParameterizedType() {
        Field[] declaredFields = ParameterizedTypeTest.class.getDeclaredFields();
        System.out.println();
        for (Field field : declaredFields) {
            //打印是否是ParameterizedType类型
            System.out.println("FieldName:" + field.getName() + "    genericType:" + field.getGenericType().getTypeName() + "   instanceof parameterizedType is " + (field.getGenericType() instanceof ParameterizedType));
        }
        System.out.println();
        getPratameterizedTypeWithName("mem");
        System.out.println();
        getPratameterizedTypeWithName("list");
        System.out.println();
        getPratameterizedTypeWithName("str");
    }

    private static void getPratameterizedTypeWithName(String name) {

        Field f;
        try {
            f = ParameterizedTypeTest.class.getDeclaredField(name);
            f.setAccessible(true);
            Type type = f.getGenericType();
            if (type instanceof ParameterizedType) {
                for (Type param : ((ParameterizedType) type).getActualTypeArguments()) {
                    //打印实际的类型
                    System.out.println("type actualType:" + param.toString());
                }
                //打印所在的父类的类型
                System.out.println("---type ownerType---" + ((ParameterizedType) type).getOwnerType());
                //打印其本身的类型
                System.out.println("---type rawType---" + ((ParameterizedType) type).getRawType());
            }


        } catch (NoSuchFieldException e) {

        }


    }

    public static void main(String[] args) {
        printParameterizedType();
    }

    class Enty<T> {
    }

}

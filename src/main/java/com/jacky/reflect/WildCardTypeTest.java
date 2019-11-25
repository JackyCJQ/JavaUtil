package com.jacky.reflect;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @auther
 */
public class WildCardTypeTest {
    public static void main(String[] args) {
        Method[] methods = WildCardTypeTest.class.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            //获取方法的所有参数类型
            Type[] types = method.getGenericParameterTypes();

            for (Type type : types) {
                System.out.println();
                System.out.println("type:" + type.toString());
                //如果不是参数化类型则直接continue，执行下一个循环条件
                if (!(type instanceof ParameterizedType)) {
                    continue;
                }
                Type type1 = ((ParameterizedType) type).getActualTypeArguments()[0];
                System.out.println("type instanceof WildcardType : " + (type1 instanceof WildcardType));
                if (type1 instanceof WildcardType) {
                    int lowIndex = ((WildcardType) type1).getLowerBounds().length - 1;
                    int upperIndex = ((WildcardType) type1).getUpperBounds().length - 1;
                    //输出上边界与下边界
                    System.out.println("getLowerBounds(): "
                            +
                            (lowIndex >= 0 ? ((WildcardType) type1).getLowerBounds()[lowIndex] : "String ")
                            + "; getUpperBounds(): "
                            +
                            (upperIndex >= 0 ? ((WildcardType) type1).getUpperBounds()[upperIndex] : "Object"));
                }
            }

        }
    }

    public void testWildcardType(List<? extends OutputStream> numberList,
                                 List<? super InputStream> upperList,
                                 List<Integer> list,
                                 InputStream inputStream) {
    }
}



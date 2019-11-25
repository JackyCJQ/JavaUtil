package com.jacky.reflect;

import java.lang.reflect.TypeVariable;

/**
 * @auther
 */
public class TypeVariableBeanTest<K extends Number, T> {

    //K有指定了上边界Number
    K key;
    //T没有指定上边界，其默认上边界为Object
    T value;

    public static void main(String[] args) {

        TypeVariable<Class<TypeVariableBeanTest>>[] parameters = TypeVariableBeanTest.class.getTypeParameters();
        for (TypeVariable<Class<TypeVariableBeanTest>> parameter : parameters) {

            int index = parameter.getBounds().length - 1;
            //输出上边界
            System.out.println("getBounds():"+parameter.getBounds()[index]);
            //输出名称
            System.out.println("getName():"+parameter.getName());
            //输出所在的类型
            System.out.println("getGenericDeclararion():"+parameter.getGenericDeclaration());


        }


    }

}

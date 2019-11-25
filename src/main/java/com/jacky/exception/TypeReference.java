
package com.jacky.exception;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 这个地方声明为抽象类，可以获取参数的类型
 */
public abstract class TypeReference<T> {

    //引用的原生类型
    private final Type rawType;

    protected TypeReference() {
        rawType = getSuperclassTypeParameter(getClass());
    }

    Type getSuperclassTypeParameter(Class<?> clazz) {
        // 获取到直接父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        //如果T的直接父类为Class类型
        if (genericSuperclass instanceof Class) {
            // try to climb up the hierarchy until meet something useful
            //找到最终的父类为TypeReference，因为最原始的就是在这个地方定义的
            if (TypeReference.class != genericSuperclass) {
                return getSuperclassTypeParameter(clazz.getSuperclass());
            }
            throw new RuntimeException("'" + getClass() + "' extends TypeReference but misses the type parameter. "
                    + "Remove the extension or add a type parameter to it.");
        }
        //获得第一个泛型化的参数
        Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        // TODO remove this when Reflector is fixed to return Types
        //如果参数化的类型还是参数化
        if (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        //声明此类型的类或接口
        return rawType;
    }

    public final Type getRawType() {
        return rawType;
    }

    @Override
    public String toString() {
        return rawType.toString();
    }

}

package com.jacky.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Authror jacky
 * @create 2019-04-25
 */
public class ServiceProxy implements InvocationHandler {
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        System.out.println("----proxy----" + method.getName());
        return null;
    }
}

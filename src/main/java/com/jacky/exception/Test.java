package com.jacky.exception;

import java.lang.reflect.Type;

/**
 * @Authror jacky
 * @create 2019-11-09
 */
public class Test {

    @org.junit.Test
    public void test() {
        Service service = new Service();
        String aaa = service.getName("jacky");
        System.out.println(aaa);
    }

    @org.junit.Test
    public void test1() {
//        ParameterizedBean bean = new ParameterizedBean();
//        Field[] fields = bean.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName()+":"+(field.getGenericType() instanceof ParameterizedType));
//            if(field.getGenericType() instanceof ParameterizedType){
//                System.out.println(((ParameterizedType) field.getGenericType()).getRawType().getTypeName());
//            }
//        }
//
//        Demo<String> demo=new Demo<>("aa");
//        Class<? extends Demo> demoClass = demo.getClass();
//        System.out.println(demoClass.getGenericSuperclass());
//
//        System.out.println(demo.getClass().getTypeName());
    }

    @org.junit.Test
    public void test2(){
        StringReference reference=new StringReference();
        Type type = reference.getRawType();
        System.out.println(type.getTypeName());
    }
    @org.junit.Test
    public void test3(){
        System.out.println(Demo.class.getTypeParameters().length);
    }

    @org.junit.Test
    public void test4(){
        System.out.println(Inter1.class.getInterfaces().length);
    }

}

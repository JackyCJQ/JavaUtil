package com.jacky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther
 */
public class BaseFastjson01 {


    @Test
    public void test01() {
        List<Person> list = new ArrayList<>();
        Person stu1 = new Person("Bob", 24);
        Person stu2 = new Person("lily", 23);
        list.add(stu1);
        list.add(stu2);
        System.out.println("单个bean:");
        System.out.println(JSON.toJSONString(stu1));
        System.out.println("list:");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test02() {
        String person = "{\"age\":24,\"name\":\"Bob\"}";
        String persons = "[{\"age\":24,\"name\":\"Bob\"},{\"age\":23,\"name\":\"lily\"}]";

        Person object = JSON.parseObject(person, Person.class);
        System.out.println("单个bean的转化");
        System.out.println(object);
        System.out.println("----------------------");
        Person stu1 = new Person("Bob", 24);
        JSONObject json = (JSONObject) JSON.toJSON(stu1);
        System.out.println(json.get("name") + ":" + json.get("age"));
        System.out.println("----------------------");
        Person person1 = JSON.toJavaObject(json, Person.class);
        System.out.println(person1);
    }

    @Test
    public void test3() {
        List<Person> list = new ArrayList<>();
        Person stu1 = new Person("Bob", 24);
        Person stu2 = new Person("lily", 23);
        list.add(stu1);
        list.add(stu2);
        JSONArray jsonArrays = (JSONArray) JSON.toJSON(list);
        for (int i = 0; i < jsonArrays.size(); i++) {
            System.out.println(jsonArrays.getJSONObject(i));
        }
        System.out.println();
        List<Person> myList=new ArrayList<>();
        for (int i = 0; i < jsonArrays.size(); i++) {


            System.out.println(jsonArrays.getJSONObject(i).toJSONString());


        }







    }


}

class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}




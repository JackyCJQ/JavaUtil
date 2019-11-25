package com.jacky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther
 */
public class BaseFastjson {

    /**
     * JSONObject从String中得到数据，提取数据，并且输出数据
     */
    @Test
    public void test01() {
        //json转为String
        String jsonStr = "{\"password\":\"123456\",\"username\":\"张三\"}";
        JSONObject object = JSONObject.parseObject(jsonStr);
        System.out.println("jsonObj-->" + object);
        //可以获取具体类型的数据
        System.out.println(object.getString("username"));
        System.out.println(object.getInteger("password"));
        System.out.println(object.getString("password"));
        //JsonObject转为json字符串
        System.out.println(object.toJSONString());
    }

    /**
     * map和json相互转化
     */
    @Test
    public void test02() {
        Map map = new HashMap();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        //map转为json
        String string = JSON.toJSONString(map);
        System.out.println(string);
        //json转为map
        String data = "{\"k1\":\"v1\",\"k2\":\"v2\",\"k3\":\"v3\"}";
        JSONObject jsonObject = JSONObject.parseObject(data);
        Map<String, Object> tmp = (Map<String, Object>) jsonObject;
        System.out.println(tmp.get("k1"));

        //map转为json
        JSONObject object = new JSONObject(map);
        System.out.println("json对象为：" + object);
    }

    /**
     * json直接添加数据
     */
    @Test
    public void test03() {
        JSONObject data = new JSONObject();
        data.put("username", "张三");
        data.put("password", "12345");
        data.put("username2", "张三");
        data.put("password", "lisi");
        System.out.println("json:-<" + data.toJSONString());
    }

    /**
     * json和对象之间的转化
     */
    @Test
    public void test04() {
        String json3 = "{id:'1001',name:'张三',age:'22'}";
        JSONObject object = JSONObject.parseObject(json3);
        Student student = JSONObject.toJavaObject(object, Student.class);
        System.out.println(student);
    }


}


class Student {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

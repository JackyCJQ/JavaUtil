package com.jacky.log;

import org.junit.Test;

/**
 * @auther
 */
public class TestLog {
    public static void main(String[] args) {
        BaseResult<CardParam> result=new BaseResult<CardParam>();
        CardParam param=new CardParam();
        param.setCityCode("sss");
        param.setLatitude(1.0);
        param.setLongitude(2.0);
        result.setCode(0);
        result.setData(param);
        System.out.println(result.getData());
    }


    @Test
    public void test(){

        Class<? extends Class> aClass = TestLog.class.getClass();


    }
}

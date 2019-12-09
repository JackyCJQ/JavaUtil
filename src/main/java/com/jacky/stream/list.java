package com.jacky.stream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther
 */
public class list {

    @Test
    public void format01() {
        File file = new File("/Users/jacky/Desktop/test.txt");
        BufferedReader reader = null;
        System.out.println("开始");
        String sql = "select * from  `spock_order_ext`  where user_id=%s and create_time<=%s limit 1;";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] split = tempString.split("\t");
                System.out.println(String.format(sql,split[0],"'"+split[1]+"'"));
//                System.out.print(tempString+",");
            }
            reader.close();
            System.out.println("结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}

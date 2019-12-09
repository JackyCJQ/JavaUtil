package com.jacky.stream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @auther
 */
public class io {
    @Test
    public void format01() {
        File file = new File("/Users/jacky/Desktop/t.txt");
        File file1 = new File("/Users/jacky/Desktop/a.txt");

        BufferedReader reader = null;
        BufferedReader reader1 = null;
        System.out.println("开始");
        String sql = "INSERT INTO `mbk_spock_partner_bike` ( `agent_id`, `bike_id`, `update_time`, `create_time`) VALUES(654, '%s', '2019-11-12 15:40:46', '2019-11-12 15:40:46');";
        try {
            reader = new BufferedReader(new FileReader(file));
            reader1 = new BufferedReader(new FileReader(file1));
            String tempString = null;
            String tmp = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null && ((tmp = reader1.readLine()) != null)) {
                System.out.println(tmp+"&"+tempString);
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

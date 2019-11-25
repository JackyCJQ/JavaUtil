package com.jacky.jdk8.ch10;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Jacky on 2019/3/18.
 */
public class TestSimpleDateFormat {
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> call = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20190318");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(call));
        }
        //这里就会存在并发的访问 线程安全问题
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
    }

    //通过threadLocal来解决
    @Test
    public void test2() throws ExecutionException, InterruptedException {

        Callable<Date> call = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20190318");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(call));
        }
        //这里就会存在并发的访问 线程安全问题
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
    //通过LocalDate来解决
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> call = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return  LocalDate.parse("20190318",dtf);
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(call));
        }
        //这里就会存在并发的访问 线程安全问题
        for (Future<LocalDate> future : results) System.out.println(future.get());

    }
}

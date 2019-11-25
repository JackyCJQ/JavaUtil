package com.jacky.jdk8.ch10;

import org.junit.Test;

import java.time.*;

/**
 * LocalDate,LocalTime,LocalDateTime类的实例是不可变对象，分别表示使用ISO-8601日历系统的日期，时间，日期和时间。
 * <p>
 * <p>
 * <p>
 * Created by Jacky on 2019/3/18.
 */
public class TestTimeAPI {

    //1.localDate localTime localDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime dateTime = LocalDateTime.of(2015, 10, 19, 13, 22, 44);
        System.out.println(dateTime);
        //日期的运算 +
        System.out.println(ldt.plusDays(2));
        System.out.println(dateTime.plusHours(2));
        //日期的运算 -
        System.out.println(ldt.minusDays(2));

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
    }

    //2.Instant:时间戳(已unix 元年：1970年1月1日 00:00：00 到现在时间之间的毫秒值)
    @Test
    public void test2() {
        //默认获取的是   UTC时区
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime time = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);
        System.out.println(now.toEpochMilli());

        Instant instant = Instant.ofEpochSecond(1000);
        System.out.println(instant);

    }

    //3.
    // Duration:计算两个“时间”之间的间隔
    //Period：计算两个”日期“之间的间隔
    @Test
    public void test3() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(100);
        Instant ins3 = Instant.now();
        System.out.println(Duration.between(ins1, ins3).toMillis());
        System.out.println("------------------------------");
        LocalDateTime ldt = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(Duration.between(ldt, ldt1).toMillis());
    }
    @Test
    public void test4(){
        LocalDate ld= LocalDate.of(2015,1,1);
        LocalDate ld1= LocalDate.now();
        Period duration = Period.between(ld, ld1);
        System.out.println(duration);
        System.out.println(duration.getYears());

    }


}

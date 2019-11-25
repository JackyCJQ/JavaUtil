package com.jacky.jdk8.ch10;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by Jacky on 2019/3/18.
 */
public class TestNewDateAPI {
    //TemporalAdjuster:时间校正器
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);
        LocalDateTime dateTime = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(dateTime);
        LocalDateTime with = now.with((l) -> {
            LocalDateTime ld = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ld.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ld.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ld.plusDays(2);
            } else {
                return ld.plusDays(1);
            }

        });
        System.out.println(with);
    }

    //DateTimeFormatter:格式化日期/时间
    @Test
    public void test2() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTime = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(now.format(dateTime));
        dateTime = DateTimeFormatter.ISO_DATE;
        System.out.println(now.format(dateTime));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(pattern.format(now));
        TemporalAccessor parse = pattern.parse("2019年03月18日");
        System.out.println(parse);
    }
    //带时区的时间 ZonedDate,ZonedTime,ZonedDateTime
    //其中每个时区都对应着ID。地区ID都为"{区域}/{城市}"的格式，例如:Asia/Shanghai等

    @Test
    public void test3() {
        Set<String> ids = ZoneId.getAvailableZoneIds();
        ids.forEach(System.out::println);
    }
    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Chisinau"));
        System.out.println(now);
        LocalDateTime now1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.of("Europe/Chisinau"));
        System.out.println(zonedDateTime);

    }


}

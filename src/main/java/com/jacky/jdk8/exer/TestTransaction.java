package com.jacky.jdk8.exer;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Authror jacky
 * @create 2019-03-17
 */
public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1.找出2011年发生的所有交易，并按交易额排序（从低到高）
    @org.junit.Test
    public void test1() {
        List<Transaction> collect = transactions.stream().filter(t -> t.getYear() == 2011).sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @org.junit.Test
    public void test2() {
        List<String> list = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @org.junit.Test
    public void test3() {
        List<Trader> collect = transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @org.junit.Test
    public void test4() {
        List<String> list = transactions.stream().map(t -> t.getTrader().getName())
                .sorted().collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("------------");
        String s = transactions.stream().map(t -> t.getTrader().getName())
                .sorted().reduce("", String::concat);
        System.out.println(s);
        System.out.println("------------");
        List<String> strings = transactions.stream().map(t -> t.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        strings.forEach(System.out::print);

    }

    public static Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }
        return list.stream();
    }

    //5. 有没有交易员是在米兰工作的？
    @org.junit.Test
    public void test5() {
        boolean b = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @org.junit.Test
    public void test6() {
        Optional<Integer> reduce = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    //7. 所有交易中，最高的交易额是多少
    @org.junit.Test
    public void test() {
        Optional<Integer> max = transactions.stream().map(t -> t.getValue())
                .max(Integer::compare);
        System.out.println(max.get());
    }

    //8. 找到交易额最小的交易
    @org.junit.Test
    public void test8() {
        Optional<Transaction> min = transactions.stream().min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());
    }
}

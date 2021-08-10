package com.jx.platform;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {

        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = new BigDecimal(10);

        a.add(b);
        System.out.println(a);
        System.out.println(a.add(b));


    }

    public void aa(){
        List<Apple> list = new ArrayList<>();

        list.add(new Apple("A", 1));
        list.add(new Apple("B", 2));
        list.add(new Apple("C", 3));
        list.add(new Apple("D", 4));

        Integer x = list.stream().mapToInt(Apple::getSize).sum();

        System.out.println(x);
    }
}
@Data
class Apple{


    private String name;
    private Integer size;
    public Apple(String name,Integer size){
        this.name = name;
        this.size = size;
    }
}

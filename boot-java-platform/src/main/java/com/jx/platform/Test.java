package com.jx.platform;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}

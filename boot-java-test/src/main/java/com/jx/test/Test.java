package com.jx.test;

import java.util.Optional;

public class Test {

    public static final String AUTH = "dSA";

    public static void main(String[] args) {

        Optional<String> optionalS = Optional.of("00");
        System.out.println("--"+AUTH);
        optionalS.ifPresent(System.out::println);
        System.out.println("--"+AUTH);

    }
}

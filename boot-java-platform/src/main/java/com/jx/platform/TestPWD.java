package com.jx.platform;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPWD {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String a = "123456";

        for (int i = 0; i < 10; i++) {
            System.out.println(encoder.encode(a));  ;

        }



    }
}

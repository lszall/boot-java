package com.jx.platform;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        new BCryptPasswordEncoder().encode("123456");
//        String password = "123456";
//        System.out.println(new BCryptPasswordEncoder().encode(password));
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(BCrypt.gensalt().length());
//        }

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now());
        System.out.println(dtf2.format(LocalDateTime.now()));

    }
}

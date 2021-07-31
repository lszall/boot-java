package com.jx.platform;

import com.jx.platform.framework.security.jwt.TokenAuthenticationHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        Integer a = 1000 * 60 * 60 * 24 ;

        System.out.println(a);
       Date date= new Date(System.currentTimeMillis() + a);

        System.out.println(date);
    }
}

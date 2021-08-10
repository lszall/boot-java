package com.jx.platform;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.jws.Oneway;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestPWD {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        for (int i = 0; i < 100; i++) {
            final int ss = i;
            executor.execute(() -> {
                System.out.println("--" + ss);
            });
        }
        System.out.println("----mian");

        executor.shutdown();
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(12);
    }

}

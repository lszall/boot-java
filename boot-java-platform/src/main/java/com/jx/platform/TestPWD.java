package com.jx.platform;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.jws.Oneway;
import java.net.InetAddress;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestPWD {

    public static void main(String[] args) throws Exception{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: "+addr.getHostAddress());
                String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);

    }

}

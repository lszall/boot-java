package com.jx.test.controller;

import java.util.ArrayList;
import java.util.List;

public class Apples implements Runnable {
    @Override
    public void run() {
        dotask();
    }

    public void dotask(){
        while (true){
            for (int i = 0; i <Integer.MAX_VALUE ; i++) {
                for (int j = 0; j < 100 ; j++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i + j);

                }

            }

        }
    }
}

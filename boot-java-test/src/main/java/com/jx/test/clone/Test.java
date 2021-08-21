package com.jx.test.clone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws Exception{
        A a = new A("aa", 11);
        B b = new B("bb", 22, a);
        String s = JSON.toJSONString(b);


        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);
     //   B b2 = mapper.readValue(s, B.class);
        B b2 = JSONObject.toJavaObject(jsonObject, B.class);
        a.setAge(33);

        System.out.println(b.getA().getAge());
        System.out.println(b2.getA().getAge());
    }
}

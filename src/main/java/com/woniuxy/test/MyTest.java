package com.woniuxy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class MyTest {
    @Test
    public void test() throws UnsupportedEncodingException {
       String mname = new String(new String("å·´").getBytes("iso8859-1"),"utf-8");
       System.out.println(mname);
    }

    @Test
    public void shirotest(){
        System.out.println(UUID.randomUUID());
    }



}

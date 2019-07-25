package com.woniuxy.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class HashUtils {
    @Test
    public void getHash(){
        System.out.println(new SimpleHash("md5","123","salt",2));
    }
}

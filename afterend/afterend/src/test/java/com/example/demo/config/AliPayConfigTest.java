package com.example.demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AliPayConfigTest {
    @Autowired
    AliPayConfig aliPayConfig;

    @Test
    public void testyReadId(){
        System.out.println(aliPayConfig.getAppId());
    }
}

package com.example.demo.service;

import java.math.BigDecimal;

public interface AliPayService {
    public String toPay(String subject, BigDecimal money) throws Exception;
}

package com.example.demo.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.example.demo.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class AliPayServiceImpl implements AliPayService {
    @Override
    public String toPay(String subject, BigDecimal money) throws Exception {
        // 最后一个参数是支付完成之后跳转到的界面, 一般为项目的首页
        AlipayTradePagePayResponse pay = Factory.Payment.Page().pay(subject, this.generateTradeNo(),
                String.valueOf(money), "http://127.0.0.1:8848/Q/1.html");
        String payForm = null;
        if (ResponseChecker.success(pay)) {
            payForm = pay.getBody();
        }
        return payForm;//成功之后会返回一个页面，也就是22行的"http://127.0.0.1"
    }

    /**
     * 通过时间生成外部订单号 out_trade_no，也可以使用uuid或者雪花算法生成
     * @return 表单号码
     */
    private String generateTradeNo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String tradeNo = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        log.error(tradeNo);
        return tradeNo;
    }
}

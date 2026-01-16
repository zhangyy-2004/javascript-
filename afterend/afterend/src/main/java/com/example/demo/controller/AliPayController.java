package com.example.demo.controller;

import com.example.demo.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
//调用服务需要的调用地址
@RestController
@CrossOrigin
@RequestMapping
@Slf4j //日志
public class AliPayController {
    @Autowired
    AliPayService service;  //用service调用服务

    @GetMapping("/pay/{projectname}/{price}")
    public String toPay(@PathVariable String projectname, @PathVariable BigDecimal price) throws Exception {//两个变量， projectname产品名，BigDecimal price产品价格
        log.error(service.toString());
        String form = service.toPay(projectname, price);
        log.error(form);
        return form;
    }
}

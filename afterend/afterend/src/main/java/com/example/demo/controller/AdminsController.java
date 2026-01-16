package com.example.demo.controller;
//调用login方法(全流程：先在AdminsService中添加方法签名，然后在AdminsServiceImpl中实现login 方法，最后在AdminsService中进行调用)
import com.example.demo.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminsController {
    @Autowired
    AdminsService adminsService;


   @RequestMapping("/login")
    public boolean login(String username,String password){
        return adminsService.login(username,password);

    }
}

package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Admins;

public interface AdminsService extends IService<Admins> {
    boolean login(String username,String password);//添加login方法签名

}

package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Cart;

public interface CartService extends IService<Cart> {
    //添加购物车，这是用户自己定义的对数据操作的方法
    boolean addCart(String uname,int pid);
}

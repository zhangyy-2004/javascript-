package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Admins;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.mapper.CartMapper;
import com.example.demo.service.AdminsService;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    AdminsService adminsService;
    @Autowired
    ProductService productService;
    @Override
    public boolean addCart(String uname, int pid) {
        //根据name查出id
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_name", uname);
        Integer uid = adminsService.getOne(wrapper).getAdminId();
        //查询出商品数据
        Product product = productService.getById(pid);
        //然后查询当前数据库表中是否已经有相关的信息
        CartMapper mapper = this.baseMapper;
        Cart cart = mapper.selectOne(new QueryWrapper<Cart>().eq("user_id", uid).eq("pro_id", pid));
        if(cart != null){
            //如果有，则进行数量更新，数量+1
            cart.setNum(cart.getNum() + 1);
            cart.setTotolPrice(cart.getNum() * cart.getProPrice());
           if(mapper.updateById(cart)!=0){
               return true;
           }
        }else{
           cart = new Cart();
            cart.setUserId(uid);
            cart.setProId(pid);
            cart.setProName(product.getProName());
            cart.setProPrice(product.getProPrice());
            cart.setNum(1);
            cart.setTotolPrice(product.getProPrice());
            if( mapper.insert(cart)!=0){
                return true;
            }

        }
        return false;
    }
}

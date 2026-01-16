package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping()
    public List<Users> findAll() {
        //从表中查询所有的数据，使用service的list方法
        return usersService.list();
    }

    //案例：通过实体bean传递参数，并保存到数据库表中
    @PostMapping("/save")
    public boolean save(@RequestBody Users users) {
        //使用mybatis-plus的save方法保存数据，返回数据类型为布尔值
        return usersService.save(users);
    }

    @GetMapping("/find")
    public Users findById(@RequestParam(value = "aname",required = false,defaultValue = "王刚是狗杂种") String name, Integer age) {
        //使用mybatis-plus的时候，按照条件进行查询
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        //第一个参数是列名，第二个参数是值
        wrapper.eq("user_name", name);
        wrapper.eq("user_age", age);
        return usersService.getOne(wrapper);
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        //使用mybatis-plus的delete方法删除数据，返回数据类型为布尔值
        return usersService.removeById(id);
    }
   //GET (SELECT): 从服务器取出资源（一项或多项）
    // POST (CREATE): 在服务器新建一个资源
    // PUT (UPDATE): 在服务器更新完整的资源（客户端提供改变后的完整资源）
    // PATCH (UPDATE)：在服务器更新资源(客户端提供改变的属性)
    // DELETE (CREATE): 从服务器删除资源
}

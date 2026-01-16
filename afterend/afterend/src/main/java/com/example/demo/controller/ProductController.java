package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/list/{pageNum}")//翻页的页码
    public List<Product> findByPage(@PathVariable int pageNum){
        IPage<Product> page=new Page<>(pageNum,9);
        return productService.list(page);//分页的page作为参数，传到list查询列表当中
    }
    @GetMapping("/rows")
    public long getRows(){
        return productService.count();
    }
    //↓↓↓准删除代码↓↓↓
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return  productService.removeById(id);
    }
    @GetMapping("/get/{id}")
    public Product getOne(@PathVariable int id){
        return productService.getById(id);
    }
    @PostMapping("/update")
    public boolean update(@RequestBody Product product){
        return productService.updateById(product);
    }
}

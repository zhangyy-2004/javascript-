package com.example.demo.controller;

import com.example.demo.service.CartService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin

public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/add/{uname}/{pid}")
    public boolean addCart(@PathVariable  String uname, @PathVariable int pid) {
      return cartService.addCart(uname, pid);
    }
}

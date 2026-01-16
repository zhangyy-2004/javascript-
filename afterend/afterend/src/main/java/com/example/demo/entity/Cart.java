package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("cart")
public class Cart {
    @TableId(type = IdType.AUTO)
    private int cartId;
    private int userId;
    private int proId;
    private String proName;
    private int proPrice;
    private int num;
    private int totolPrice;

}

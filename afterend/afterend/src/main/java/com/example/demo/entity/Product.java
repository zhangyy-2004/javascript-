package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @TableId(type = IdType.AUTO)
    private int proId;
    private  String proName;
    private String proImg;
    private int star;
    private int proPrice;
    private  String proDes;
    private Data proTime;
    private String proSupp;

}

package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userAddr;
}

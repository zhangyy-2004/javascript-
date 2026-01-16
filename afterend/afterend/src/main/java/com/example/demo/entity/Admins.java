package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admins {
    @TableId(type = IdType.AUTO)
    private Integer adminId;
    private String adminName;
    private String adminPass;
    private String adminNick;

}

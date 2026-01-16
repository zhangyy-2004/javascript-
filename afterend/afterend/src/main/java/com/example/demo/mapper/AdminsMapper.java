package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Admins;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminsMapper extends BaseMapper<Admins> {
}

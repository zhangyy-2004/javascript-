package com.example.demo.service.impl;
//文件属于实现类，实现目标方法login
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Admins;
import com.example.demo.mapper.AdminsMapper;
import com.example.demo.service.AdminsService;
import org.springframework.stereotype.Service;

@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements AdminsService {
    @Override
    public boolean login(String username, String password) {
        AdminsMapper mapper=getBaseMapper();
        QueryWrapper<Admins> wrapper=new QueryWrapper<>();
        wrapper.eq("admin_name",username).eq("admin_pass",password);
        Admins admin=mapper.selectOne(wrapper);
        if (admin==null)
            return false;
        else
            return true;
    }
}

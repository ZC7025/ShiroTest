package com.zc.service.impl;

import com.zc.dao.AdminMapper;
import com.zc.pojo.Admin;
import com.zc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 7025 on 2017/10/20.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getByNamePwd(String name, String password) {
        return adminMapper.getByNamePwd(name, password);
    }
}

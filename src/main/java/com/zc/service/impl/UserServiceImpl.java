package com.zc.service.impl;

import com.zc.dao.UserMapper;
import com.zc.pojo.User;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 7025 on 2017/10/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByNamePwd(String name, String password) {
        return userMapper.getByNamePwd(name, password);
    }
}

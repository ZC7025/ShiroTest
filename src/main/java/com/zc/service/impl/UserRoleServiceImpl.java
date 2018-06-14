package com.zc.service.impl;

import com.zc.dao.UserRoleMapper;
import com.zc.pojo.UserRoleVO;
import com.zc.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleMapper userRoleMapper;

    @Autowired
    public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }


    @Override
    public List<UserRoleVO> listById(Integer id) {
        return userRoleMapper.listById(id);
    }
}

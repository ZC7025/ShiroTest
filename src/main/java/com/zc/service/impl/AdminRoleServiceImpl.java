package com.zc.service.impl;

import com.zc.dao.AdminRoleMapper;
import com.zc.pojo.AdminRoleVO;
import com.zc.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    private AdminRoleMapper adminRoleMapper;

    @Autowired
    public void setAdminRoleMapper(AdminRoleMapper adminRoleMapper) {
        this.adminRoleMapper = adminRoleMapper;
    }


    @Override
    public List<AdminRoleVO> listById(Integer id) {
        return adminRoleMapper.listById(id);
    }
}

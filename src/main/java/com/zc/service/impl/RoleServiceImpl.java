package com.zc.service.impl;

import com.zc.dao.RoleMapper;
import com.zc.pojo.RolePermissionVO;
import com.zc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RolePermissionVO> listById(Long id) {
        return roleMapper.listById(id);
    }
}

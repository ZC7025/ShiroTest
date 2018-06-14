package com.zc.service;

import com.zc.pojo.RolePermissionVO;

import java.util.List;

public interface RoleService {

    List<RolePermissionVO> listById(Long id);
}

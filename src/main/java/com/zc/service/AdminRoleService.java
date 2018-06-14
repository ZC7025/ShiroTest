package com.zc.service;

import com.zc.pojo.AdminRoleVO;

import java.util.List;

public interface AdminRoleService {

    List<AdminRoleVO> listById(Integer id);
}

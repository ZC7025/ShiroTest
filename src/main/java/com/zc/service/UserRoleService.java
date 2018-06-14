package com.zc.service;

import com.zc.pojo.UserRoleVO;

import java.util.List;

public interface UserRoleService {

    List<UserRoleVO> listById(Integer id);
}

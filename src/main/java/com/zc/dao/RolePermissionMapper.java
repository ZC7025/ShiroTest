package com.zc.dao;

import com.zc.pojo.RolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapper {
    int deleteById(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectById(Long id);

    int updateByIdSelective(RolePermission record);

    int updateById(RolePermission record);
}
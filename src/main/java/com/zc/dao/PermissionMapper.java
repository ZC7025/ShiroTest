package com.zc.dao;

import com.zc.pojo.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {
    int deleteById(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectById(Long id);

    int updateByIdSelective(Permission record);

    int updateById(Permission record);
}
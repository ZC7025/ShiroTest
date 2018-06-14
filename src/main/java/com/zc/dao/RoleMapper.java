package com.zc.dao;

import com.zc.pojo.Role;
import com.zc.pojo.RolePermissionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteById(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectById(Long id);

    int updateByIdSelective(Role record);

    int updateById(Role record);

    List<RolePermissionVO> listById(Long id);
}
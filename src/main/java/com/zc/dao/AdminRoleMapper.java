package com.zc.dao;

import com.zc.pojo.AdminRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoleMapper {
    int deleteById(Long id);

    int insert(AdminRoleVO record);

    int insertSelective(AdminRoleVO record);

    AdminRoleVO selectById(Long id);

    int updateByIdSelective(AdminRoleVO record);

    int updateById(AdminRoleVO record);

    List<AdminRoleVO> listById(Integer id);
}
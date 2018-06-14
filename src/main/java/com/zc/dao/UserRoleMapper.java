package com.zc.dao;

import com.zc.pojo.UserRole;
import com.zc.pojo.UserRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int deleteById(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectById(Long id);

    int updateByIdSelective(UserRole record);

    int updateById(UserRole record);

    List<UserRoleVO> listById(Integer id);
}
package com.zc.dao;

import com.zc.pojo.Admin;
import com.zc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteById(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Long id);

    int updateByIdSelective(User record);

    int updateById(User record);

    Admin getByNamePwd(@Param("name") String name, @Param("password") String password);

}
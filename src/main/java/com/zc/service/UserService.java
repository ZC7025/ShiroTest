package com.zc.service;

import com.zc.pojo.User;

public interface UserService {

    User getByNamePwd(String name, String password);

}

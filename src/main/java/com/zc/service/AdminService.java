package com.zc.service;

import com.zc.pojo.Admin;

public interface AdminService {

    Admin getByNamePwd(String name, String password);

}

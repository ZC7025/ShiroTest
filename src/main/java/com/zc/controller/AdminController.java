package com.zc.controller;

import com.zc.common.CustomerLoginToken;
import com.zc.pojo.Admin;
import com.zc.pojo.UserType;
import com.zc.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 7025 on 2017/10/20.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new CustomerLoginToken(admin.getName(),admin.getPassword(), UserType.ADMIN));
            String username =  (String) subject.getPrincipal();
            System.out.println(username);
            System.out.println(subject.hasRole("admin"));
            System.out.println(subject.isPermitted("admin:login"));
        } catch (UnknownAccountException e) {
            return "用户名或密码错误";
        }
        return "login";
    }

    @RequestMapping("login_page")
    public String loginPage() {
        return "admin/login";
    }
}

package com.zc.controller;

import com.zc.common.CustomerLoginToken;
import com.zc.pojo.User;
import com.zc.pojo.UserType;
import com.zc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 7025 on 2017/10/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public String login(User user) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new CustomerLoginToken(user.getName(),user.getPassword(), UserType.USER));
            String username =  (String) subject.getPrincipal();
            System.out.println(username);
            System.out.println(subject.hasRole("root"));
            System.out.println(subject.isPermitted("user:login"));
        } catch (UnknownAccountException e) {
            return "用户名或密码错误";
        }
        return "login";
    }

    @RequestMapping("login_page")
    public String loginPage() {
        return "user/login";
    }
}
